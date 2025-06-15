package com.example.studentlifeorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.studentlifeorganizer.databinding.ActivityAddAllBinding;

public class Add_all extends AppCompatActivity {

    ActivityAddAllBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityAddAllBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.cvLecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Add_all.this, Add_lectures.class);
                startActivity(intent);
            }

        });
        binding.cvNots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Add_all.this,AddNote.class);
                startActivity(intent);
            }
        });
        binding.cvExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Add_all.this, AddExamDates.class);
                startActivity(intent);
            }
        });
        binding.cvProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Add_all.this, Add_projects.class);
                startActivity(intent);
            }
        });
        binding.cvTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Add_all.this, AddTaskeAndHomework.class);
                startActivity(intent);
            }
        });
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Add_all.this, DetailsActivity.class);
                startActivity(intent1);
            }
        });
    }
}