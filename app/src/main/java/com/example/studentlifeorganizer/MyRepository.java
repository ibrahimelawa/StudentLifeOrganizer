package com.example.studentlifeorganizer;

import android.app.Application;

public class MyRepository {
    private final UserDao userDao;
    MyRepository(Application application) {
        MyDatabase db = MyDatabase.getDatabase(application);
        userDao= db.userDao();

    }
    void insertUser (User user){
        MyDatabase.databaseWriteExecutor.execute(()->{
                    userDao.insertUser(user);
                }
        );
    }
    void deleteUser (User user){
        MyDatabase.databaseWriteExecutor.execute(()->{
                    userDao.deleteUser(user);
                }
        );
    }
    void updateUser (User user){
        MyDatabase.databaseWriteExecutor.execute(()->{
                    userDao.updateUser(user);
                }
        );
    }
    public User getUserByEmail(String email){
        return userDao.getAllUserByEmail(email);
    }
    User getlogin(String email,String password){
        return userDao.login( email,password);
    }
}
