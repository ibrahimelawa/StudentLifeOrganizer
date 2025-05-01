package com.example.studentlifeorganizer;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MyViewModel extends AndroidViewModel {
    private MyRepository myRepository;

    public MyViewModel(@NonNull Application application) {
        super(application);
        myRepository = new MyRepository(application);
    }

    public void insertUser(User user) {
        myRepository.insertUser(user);
    }

    public void updateUser(User user) {
        myRepository.updateUser(user);
    }

    void deleteUser(User user) {
        myRepository.deleteUser(user);
    }

    public User login(String email, String password){
        return myRepository.getlogin(email, password);
    }

    public User getUserByEmail(String email) {
        return myRepository.getUserByEmail(email);
    }
}


