package com.example.studentlifeorganizer;

public class Exam {
    private String examName;
    private String teacherName;
    private String hallNumber;
    private String time;
    private String date;

    public Exam(String examName, String teacherName, String hallNumber, String time, String date) {
        this.examName = examName;
        this.teacherName = teacherName;
        this.hallNumber = hallNumber;
        this.time = time;
        this.date = date;
    }

    public String getExamName() {
        return examName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getHallNumber() {
        return hallNumber;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
}
