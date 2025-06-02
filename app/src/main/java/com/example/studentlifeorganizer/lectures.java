package com.example.studentlifeorganizer;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
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

public class lectures extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LectureAdapter adapter;
    private List<Lecture> lectureList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectures);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        lectureList = new ArrayList<>();
        lectureList.add(new Lecture("Math", "Dr. Ahmad", "10:00 AM", "Room 1"));
        lectureList.add(new Lecture("Physics", "Prof. Huda", "11:30 AM", "Lab A"));
        lectureList.add(new Lecture("Programming", "Mr. Samer", "1:00 PM", "Room 5"));

        adapter = new LectureAdapter(lectureList, lecture -> {
            Toast.makeText(this, "Clicked: " + lecture.getMaterialName(), Toast.LENGTH_SHORT).show();
        });

        recyclerView.setAdapter(adapter);
        ImageView btnBack = findViewById(R.id.backButton);
        btnBack.setOnClickListener(v -> finish());

    }
}