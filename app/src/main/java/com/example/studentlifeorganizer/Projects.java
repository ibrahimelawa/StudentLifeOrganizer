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

public class Projects extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProjectsAdapter adapter;
    private List<Project> projectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        recyclerView = findViewById(R.id.recycler_projects);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        projectList = new ArrayList<>();
        projectList.add(new Project("Project 1", "Mr. Ahmed", "2025-06-01", "Hall A"));
        projectList.add(new Project("Project 2", "Ms. Sara", "2025-06-05", "Hall B"));

        adapter = new ProjectsAdapter(this, projectList, new ProjectsAdapter.OnItemClickListener() {
            @Override
            public void onEditClick(int position) {

                Toast.makeText(Projects.this, "تعديل العنصر " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDeleteClick(int position) {

                projectList.remove(position);
                adapter.notifyItemRemoved(position);
                Toast.makeText(Projects.this, "حذف العنصر " + position, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);


        ImageButton backButton = findViewById(R.id.button_back);
        backButton.setOnClickListener(v -> finish());
    }
}