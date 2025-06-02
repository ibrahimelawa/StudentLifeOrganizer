package com.example.studentlifeorganizer;

public class Task {
    private String taskName;
    private String description;
    private String teacherName;
    private String startDate;
    private String endDate;
    private boolean reminder;

    public Task(String taskName, String description, String teacherName, String startDate, String endDate, boolean reminder) {
        this.taskName = taskName;
        this.description = description;
        this.teacherName = teacherName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reminder = reminder;
    }

    public String getTaskName() { return taskName; }
    public String getDescription() { return description; }
    public String getTeacherName() { return teacherName; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public boolean hasReminder() { return reminder; }
}
