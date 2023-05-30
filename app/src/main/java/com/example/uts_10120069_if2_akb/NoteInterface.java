package com.example.uts_10120069_if2_akb;

import android.database.Cursor;

import com.example.uts_10120069_if2_akb.model.note;

public interface NoteInterface {

    public Cursor read();
    public boolean create(note note);
    public boolean update(note note);
    public boolean delete(String id);
}
