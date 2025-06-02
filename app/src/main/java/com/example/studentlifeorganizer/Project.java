package com.example.studentlifeorganizer;

public class Project {
    private String name;
    private String teacherName;
    private String date;
    private String hall;

    public Project(String name, String teacherName, String date, String hall) {
        this.name = name;
        this.teacherName = teacherName;
        this.date = date;
        this.hall = hall;
    }

    public String getName() {
        return name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getDate() {
        return date;
    }

    public String getHall() {
        return hall;
    }
}
