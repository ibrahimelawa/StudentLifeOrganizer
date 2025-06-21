package com.example.studentlifeorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studentlifeorganizer.databinding.ActivitySinginBinding;
import com.google.firebase.auth.FirebaseAuth;

public class Sing_in extends AppCompatActivity {
    ActivitySinginBinding binding;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySinginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();

        binding.tvSingup.setOnClickListener(v -> {
            String email = binding.etEmail.getText().toString().trim();
            String password = binding.etPassword.getText().toString().trim();

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "يرجى إدخال البريد وكلمة المرور", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(Sing_in.this, "تم تسجيل الدخول بنجاح", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Sing_in.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(Sing_in.this, "فشل تسجيل الدخول: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        });

        binding.tvForget.setOnClickListener(v -> {
            startActivity(new Intent(Sing_in.this, ForgetPassword.class));
        });

        binding.tvCreateAccount.setOnClickListener(v -> {
            startActivity(new Intent(Sing_in.this, Sing_Up.class));
        });

        binding.imgBack.setOnClickListener(v -> {
            startActivity(new Intent(Sing_in.this, OnboardingActivity.class));
        });
    }
}
