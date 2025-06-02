package com.example.studentlifeorganizer;

public class Lecture {
    private String materialName;
    private String teacherName;
    private String time;
    private String hall;

    public Lecture(String materialName, String teacherName, String time, String hall) {
        this.materialName = materialName;
        this.teacherName = teacherName;
        this.time = time;
        this.hall = hall;
    }

    public String getMaterialName() {
        return materialName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getTime() {
        return time;
    }

    public String getHall() {
        return hall;
    }

}
