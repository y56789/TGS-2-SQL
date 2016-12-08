package com.example.mr.tugassql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Mursyid on 10/11/2016.
 */


public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "biodatadiri.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
// TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
// TODO Auto-generated method stub
        String sql = "create table biodata(nim text primary key, nama text null,  tgl text null, jk text null, alamat text null , jurusan text null , angkatan text null );";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO biodata (nim, nama, tgl, jk, alamat, jurusan, angkatan) VALUES ('1137050158', 'Muhammad Mursid Naufal', '29 September 1995', 'Laki-laki','Bekasi','Teknik Informatika','2013');";
        db.execSQL(sql);


        String query2 = "CREATE TABLE tbl_user(id_user text primary key, username text null , password text null );";
        Log.d("Data", "onCreate: " + query2);
        db.execSQL(query2);

        query2 = "INSERT INTO tbl_user(id_user,username,password) VALUES ('1','admin','admin')";
        db.execSQL(query2);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
// TODO Auto-generated method stub
    }

    public int cekLogin(String username, String password)
    {
        String query ="SELECT * FROM tbl_user WHERE username='"+username+"' AND password ='" +password+ "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);
        int rowCount = c.getCount();
        db.close();
        c.close();
        return rowCount;
//      Cursor  cursor = db_SQLite.rawQuery(query,null);
//      return cursor.getCount();

    }
}