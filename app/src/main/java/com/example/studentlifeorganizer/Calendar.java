package com.example.studentlifeorganizer;

public class Calendar {
    private String title;
    private String time;
    private int iconResId;


    public Calendar(String title, String time, int iconResId) {
        this.title = title;
        this.time = time;
        this.iconResId = iconResId;
    }

    public String getTitle() { return title; }
    public String getTime() { return time; }
    public int getIconResId() { return iconResId; }


}
