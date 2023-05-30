package com.example.uts_10120069_if2_akb.view.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uts_10120069_if2_akb.NoteInterface;
import com.example.uts_10120069_if2_akb.R;
import com.example.uts_10120069_if2_akb.adapter.NoteAdapter;
import com.example.uts_10120069_if2_akb.database.db;
import com.example.uts_10120069_if2_akb.model.note;
import com.example.uts_10120069_if2_akb.view.activity.AddNoteActivity;
import com.example.uts_10120069_if2_akb.view.activity.MainActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


/**
 * NAMA    : Rendy Agustin
 * NIM     : 10120069
 * Kelas   : IF-2
 * MatKul  : Aplikasi Komputasi Bergerak
 */


public class listFragment extends Fragment {

    private MainActivity mainActivity;
    private List<note> note;
    private NoteInterface noteInterface;
    private RecyclerView recyclerView;
    private com.example.uts_10120069_if2_akb.adapter.NoteAdapter noteAdapter;
    private FloatingActionButton addButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView =  inflater.inflate(R.layout.fragment_list, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity();
        mainActivity.getSupportActionBar().hide();
        recyclerView = view.findViewById(R.id.mynote);
        addButton = view.findViewById(R.id.button_add);
        addButton.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), AddNoteActivity.class));
        });

        read();
    }

    @Override
    public void onResume() {
        super.onResume();
        read();
    }

    private void read() {
        note = new ArrayList<note>();
        noteInterface = new db(getContext());
        Cursor cursor = noteInterface.read();
        if (cursor.moveToFirst()){
            do {
                note n = new note(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2)
                );

                note.add(n);
            } while (cursor.moveToNext());
        }

        noteAdapter = new NoteAdapter(note);
        recyclerView.setAdapter(noteAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
    }
}