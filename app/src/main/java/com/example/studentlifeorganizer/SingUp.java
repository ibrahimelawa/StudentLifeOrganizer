package com.example.studentlifeorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.studentlifeorganizer.databinding.ActivitySingUpBinding;

public class SingUp extends AppCompatActivity {
   ActivitySingUpBinding binding;
    private MyViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySingUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        binding.tvSingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.etName.getText().toString().trim();
                String email = binding.etEmail.getText().toString().trim();
                String password = binding.etPassword.getText().toString().trim();

                boolean isValid = true;

                if (name.isEmpty()) {
                    binding.etName.setError("الاسم فارغ");
                    isValid = false;
                } else if (name.length() <= 3) {
                    binding.etName.setError("الاسم يجب أن يحتوي على 3 أحرف على الأقل");
                    isValid = false;
                }

                if (email.isEmpty()) {
                    binding.etEmail.setError("البريد الإلكتروني فارغ");
                    isValid = false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    binding.etEmail.setError("البريد الإلكتروني غير صالح");
                    isValid = false;
                }

                if (password.isEmpty()) {
                    binding.etPassword.setError("كلمة المرور فارغة");
                    isValid = false;
                } else if (!TextUtils.isDigitsOnly(password) || password.length() < 8) {
                    binding.etPassword.setError("يجب أن تحتوي كلمة المرور على 8 أرقام على الأقل");
                    isValid = false;
                }


                if (isValid) {
                    User user = new User(0, name, email, password);
                    myViewModel.insertUser(user);

                    Toast.makeText(SingUp.this, "تم إنشاء الحساب بنجاح", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
       binding.imgBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(SingUp.this,Singin.class);
               startActivity(intent);
           }
       });



    }
}