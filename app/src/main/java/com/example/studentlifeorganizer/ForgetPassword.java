package com.example.studentlifeorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.studentlifeorganizer.databinding.ActivityForgetPasswordBinding;


public class ForgetPassword extends AppCompatActivity {
 ActivityForgetPasswordBinding binding;
    private MyViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        binding=ActivityForgetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tvUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.etEmail.getText().toString().trim();
                String newPassword = binding.etNewPassword.getText().toString().trim();

                boolean isValid = true;

                if (email.isEmpty()) {
                    binding.etEmail.setError("يرجى إدخال البريد الإلكتروني");
                    isValid = false;
                }

                if (newPassword.isEmpty()) {
                    binding.etNewPassword.setError("يرجى إدخال كلمة مرور جديدة");
                    isValid = false;
                } else if (newPassword.length() < 8 || !TextUtils.isDigitsOnly(newPassword)) {
                    binding.etNewPassword.setError("كلمة المرور يجب أن تكون 8 أرقام على الأقل");
                    isValid = false;
                }

                if (!isValid) return;

                new Thread(() -> {
                    User user = myViewModel.getUserByEmail(email);
                    if (user != null) {
                        user.setPassword(newPassword);
                        myViewModel.updateUser(user);

                        runOnUiThread(() ->
                                Toast.makeText(ForgetPassword.this, "تم تحديث كلمة المرور بنجاح", Toast.LENGTH_SHORT).show()
                        );
                    } else {
                        runOnUiThread(() ->
                                Toast.makeText(ForgetPassword.this, "البريد الإلكتروني غير موجود", Toast.LENGTH_SHORT).show()
                        );
                    }
                }).start();
            }
        });
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ForgetPassword.this,Singin.class);
                startActivity(intent);
            }
        });




    }
}