package com.example.studentlifeorganizer;



import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "User")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String UserName;
    public String Email;
    public  String Password;

    public int getId() {
        return id;
    }

    public User() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public User(int id, String userName, String email, String password) {
        this.id = id;
        UserName = userName;
        Email = email;
        Password = password;
    }


}
