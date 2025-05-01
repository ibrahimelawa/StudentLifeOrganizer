package com.example.studentlifeorganizer;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.studentlifeorganizer.User;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);

    @Query(" SELECT * FROM user WHERE Email = :email AND Password=:password")
    User login(String email, String password);


    @Query("SELECT * FROM user WHERE email = :email")
    User getAllUserByEmail(String email);
}
