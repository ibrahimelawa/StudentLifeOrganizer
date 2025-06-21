package com.example.studentlifeorganizer;

public class UserFirebase {
    public String name;
    public String email;
    public String phone;
    public String dob;

    public UserFirebase() {


    }

    public UserFirebase(String name,String email , String phone, String dob) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDate() { return dob; }
}
