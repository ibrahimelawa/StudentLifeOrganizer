package com.example.studentlifeorganizer;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Notes extends AppCompatActivity {
    NoteAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        RecyclerView recyclerView = findViewById(R.id.notesRecyclerView);
        List<Note> notes = new ArrayList<>();
        notes.add(new Note("Study Chapter 3"));
        notes.add(new Note("Buy Stationery"));
        notes.add(new Note("Meeting at 5 PM"));

        adapter = new NoteAdapter(notes, new NoteAdapter.OnNoteClickListener() {
            @Override
            public void onEditClick(Note note, int position) {
                Toast.makeText(getApplicationContext(), "Edit: " + note.getTitle(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onDeleteClick(Note note, int position) {
                Toast.makeText(getApplicationContext(), "Deleted: " + note.getTitle(), Toast.LENGTH_SHORT).show();
                notes.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        ImageView btnBack = findViewById(R.id.backButton_notes);
        btnBack.setOnClickListener(v -> finish());

    }
}