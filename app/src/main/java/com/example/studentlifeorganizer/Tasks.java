package com.example.studentlifeorganizer;

import android.os.Bundle;
import android.widget.ImageButton;
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

public class Tasks extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    private List<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        taskList = new ArrayList<>();
        taskList.add(new Task("Math Homework", "Chapter 5 exercises", "Mr. Ahmad", "2025-06-01", "2025-06-03", true));
        taskList.add(new Task("English Essay", "Write about technology", "Ms. Sarah", "2025-06-02", "2025-06-04", false));


        taskAdapter = new TaskAdapter(this, taskList, new TaskAdapter.OnTaskClickListener() {
            @Override
            public void onEditClick(int position) {
                Toast.makeText(Tasks.this, "Edit: " + taskList.get(position).getTaskName(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onDeleteClick(int position) {
                taskList.remove(position);
                taskAdapter.notifyItemRemoved(position);
                Toast.makeText(Tasks.this, "Deleted!", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(taskAdapter);
        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> finish());

    }


}
