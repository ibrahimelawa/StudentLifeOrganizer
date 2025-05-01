package com.example.studentlifeorganizer;

import java.util.List;
@Dao
public interface UserDao {
    @Insert
    void insertUser (User user);
    @Update
    void updateUser(User user);
    @Delete
    void  deleteUser(User user);
    @Query(" SELECT * FROM user")
    LiveData<List<User>> getAllUser();
    @Query(" SELECT * FROM user WHERE Email = :email")
    User getAllUserByEmail(String email);
    @Query(" SELECT * FROM user WHERE Email = :email AND Password=:password")
    User login(String email, String password);
}
