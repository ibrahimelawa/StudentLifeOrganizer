package com.example.studentlifeorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.studentlifeorganizer.databinding.ActivityAddLecturesBinding;
import com.example.studentlifeorganizer.databinding.ActivityAddTaskeAndHomeworkBinding;

public class AddTaskeAndHomework extends AppCompatActivity {

    ActivityAddTaskeAndHomeworkBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding= ActivityAddTaskeAndHomeworkBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(AddTaskeAndHomework.this, Add_all.class);
                startActivity(intent1);
            }
        });


        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddTaskeAndHomework.this, "Saved", Toast.LENGTH_SHORT).show();

                Intent intent1=new Intent(AddTaskeAndHomework.this, Add_all.class);
                startActivity(intent1);
            }
        });

    }
}