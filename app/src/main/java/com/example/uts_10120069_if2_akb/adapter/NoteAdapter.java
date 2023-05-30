package com.example.uts_10120069_if2_akb.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_10120069_if2_akb.R;
import com.example.uts_10120069_if2_akb.database.db;
import com.example.uts_10120069_if2_akb.model.note;
import com.example.uts_10120069_if2_akb.view.activity.AddNoteActivity;

import java.util.List;

/**
 * NAMA    : Rendy Agustin
 * NIM     : 10120069
 * Kelas   : IF-2
 * MatKul  : Aplikasi Komputasi Bergerak
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private List<note> notes;

    public NoteAdapter(List<note> notes) {
        this.notes = notes;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_layout, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(notes.get(position).getTitle());
        holder.desc.setText(notes.get(position).getDesc());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), AddNoteActivity.class);
            intent.putExtra("Note", notes.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_note);
            desc = itemView.findViewById(R.id.desc_note);
        }
    }
}
