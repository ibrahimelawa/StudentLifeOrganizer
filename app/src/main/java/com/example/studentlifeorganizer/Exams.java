package com.example.studentlifeorganizer;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Exams extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ExamsAdapter adapter;
    private List<Exam> examList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exams);

        recyclerView = findViewById(R.id.recycler_exams);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        examList = new ArrayList<>();
        examList.add(new Exam("Math Exam", "Mr. Ali", "Hall 1", "10:00 AM", "2025-06-10"));
        examList.add(new Exam("Physics Exam", "Ms. Sara", "Hall 2", "1:00 PM", "2025-06-12"));

        adapter = new ExamsAdapter(this, examList, new ExamsAdapter.OnItemClickListener() {
            @Override
            public void onAddClick(int position) {
                Toast.makeText(Exams.this, "إضافة لعنصر رقم: " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDeleteClick(int position) {
                examList.remove(position);
                adapter.notifyItemRemoved(position);
                Toast.makeText(Exams.this, "تم حذف العنصر رقم: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);

        ImageButton backButton = findViewById(R.id.button_back);
        backButton.setOnClickListener(v -> finish());
    }
}