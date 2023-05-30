package com.example.uts_10120069_if2_akb.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.uts_10120069_if2_akb.NoteInterface;
import com.example.uts_10120069_if2_akb.model.note;

/**
 * NAMA    : Rendy Agustin
 * NIM     : 10120069
 * Kelas   : IF-2
 * MatKul  : Aplikasi Komputasi Bergerak
 */

public class db extends SQLiteOpenHelper implements NoteInterface {

    public db(@Nullable Context context) {
        super(context, "db_note", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        sqLiteDatabase.execSQL("CREATE TABLE tbl_note (id TEXT, title TEXT, description TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE tbl_note (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE tbl_note");
    }

    public Cursor read(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM tbl_note", null);
    }

    public boolean create (note note){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("INSERT INTO tbl_note VALUES ('"+note.getId()+"','"+note.getTitle()+"','"+note.getDesc()+"')");
        return true;
    }

    public boolean update (note note){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("UPDATE tbl_note SET title='"+note.getTitle()+"', description='"+note.getDesc()+"' WHERE id='"+note.getId()+"'");
        return true;
    }

    public boolean delete(String id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM tbl_note WHERE id='"+id+"'");
        return true;
    }

}
