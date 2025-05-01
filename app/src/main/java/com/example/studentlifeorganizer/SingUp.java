package com.example.studentlifeorganizer;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.studentlifeorganizer.databinding.ActivitySingUpBinding;

public class SingUp extends AppCompatActivity {
   ActivitySingUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySingUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tvSingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=   binding.etName.getText().toString();
                String password=binding.etPassword.getText().toString();
                String email=binding.etEmail.getText().toString();
                if ((name.isEmpty())){
                    binding.etName.setError("الاسم فارغ");
                } else if (name.length()<= 3) {
                    binding.etName.setError("الاسم يجب ان يحتوي علي الاقل علي 3 احرف ");
                } else if (email.isEmpty()) {
                    binding.etEmail.setError("البريد الالكتروني فارغ ");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    binding.etEmail.setError("البريد الالكتروني غير صالح ");
                } else if (password.isEmpty()) {
                    binding.etPassword.setError("كلمة السر فارغة ");
                } else if (!TextUtils.isDigitsOnly(password)||password.length()<8) {
                    binding.etPassword.setError("يجب ان تحتوي كلمة المرور علي 8 أرقام علي الاقل ");
                }
            }
        });



    }
}