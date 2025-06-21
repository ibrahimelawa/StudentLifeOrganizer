package com.example.studentlifeorganizer;

public class FirebaseUser {
    public String name;
    public String email;

    public FirebaseUser() {
        // مطلوب لـ Firebase
    }

    public FirebaseUser(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
}
