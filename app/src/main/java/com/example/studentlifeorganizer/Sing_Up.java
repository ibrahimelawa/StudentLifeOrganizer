package com.example.studentlifeorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studentlifeorganizer.databinding.ActivitySingUpBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sing_Up extends AppCompatActivity {
    ActivitySingUpBinding binding;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySingUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();

        binding.tvSingup.setOnClickListener(v -> {
            String name = binding.etName.getText().toString().trim();
            String email = binding.etEmail.getText().toString().trim();
            String phone = binding.etPhone.getText().toString().trim();
            String date = binding.etDob.getText().toString().trim();
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

            if (phone.isEmpty()) {
                binding.etPhone.setError("رقم الهاتف فارغ");
                isValid = false;
            }

            if (date.isEmpty()) {
                binding.etDob.setError("تاريخ الميلاد فارغ");
                isValid = false;
            }

            if (password.isEmpty()) {
                binding.etPassword.setError("كلمة المرور فارغة");
                isValid = false;
            } else if ( password.length() < 8) {
                binding.etPassword.setError("كلمة المرور يجب أن تكون 8 خانات على الأقل");
                isValid = false;
            }

            if (isValid) {
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                                DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users");

                                UserFirebase userObj = new UserFirebase(name, email, phone, date);
                                userRef.child(currentUser.getUid()).setValue(userObj);
                                Toast.makeText(Sing_Up.this, "تم إنشاء الحساب بنجاح", Toast.LENGTH_SHORT).show();
                                finish();

                            } else {
                                Toast.makeText(Sing_Up.this, "فشل إنشاء الحساب: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
            }

        });

        binding.imgBack.setOnClickListener(view -> {
            startActivity(new Intent(Sing_Up.this, Sing_in.class));
        });
    }
}
