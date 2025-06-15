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

import com.example.studentlifeorganizer.databinding.ActivityAddAllBinding;
import com.example.studentlifeorganizer.databinding.ActivityAddExamDatesBinding;

public class AddExamDates extends AppCompatActivity {
    ActivityAddExamDatesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityAddExamDatesBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(AddExamDates.this, Add_all.class);
                startActivity(intent1);
            }
        });
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddExamDates.this, "Saved", Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(AddExamDates.this, Add_all.class);
                startActivity(intent1);
            }
        });
    }
}