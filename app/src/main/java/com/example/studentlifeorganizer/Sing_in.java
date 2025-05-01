package com.example.studentlifeorganizer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.studentlifeorganizer.databinding.ActivitySinginBinding;

public class Sing_in extends AppCompatActivity {
      ActivitySinginBinding binding;
    private MyViewModel myViewModel;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySinginBinding.inflate(getLayoutInflater());
        sharedPreferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        setContentView(binding.getRoot());
        binding.tvSingup.setOnClickListener(v -> {
            String email = binding.etEmail.getText().toString().trim();
            String password =binding.etPassword.getText().toString().trim();


            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "يرجى إدخال البيانات", Toast.LENGTH_SHORT).show();
                return;
            }

            new Thread(() -> {
                User user = myViewModel.login(email, password);
                if (user != null) {
                    if (binding.rbRemember.isChecked()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean("remember_me", true);
                        editor.putString("email", email);
                        editor.putString("password", password);
                        editor.apply();
                    }
                    runOnUiThread(() -> {
                        Toast.makeText(Sing_in.this, "تم تسجيل الدخول بنجاح", Toast.LENGTH_SHORT).show();
                         Intent intent=new Intent(Sing_in.this,MainActivity.class);
                         startActivity(intent);
                    });
                } else {
                    runOnUiThread(() -> {
                        Toast.makeText(Sing_in.this, "البيانات غير صحيحة", Toast.LENGTH_SHORT).show();
                    });
                }
            }).start();

        });
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Sing_in.this, OnboardingActivity.class);
                startActivity(intent1);
            }
        });
        binding.tvForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sing_in.this, ForgetPassword.class);
                startActivity(intent);
            }
        });
        binding.tvCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(Sing_in.this, Sing_Up.class);
               startActivity(intent);
            }
        });

    }
}