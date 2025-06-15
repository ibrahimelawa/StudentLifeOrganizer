package com.example.studentlifeorganizer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder> {

    private List<Calendar> calendarList;

    public CalendarAdapter(List<Calendar> calendarList) {
        this.calendarList = calendarList;
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_recycler_view_calendar, parent, false);
        return new CalendarViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        Calendar calendar = calendarList.get(position);
        holder.title.setText(calendar.getTitle());
        holder.time.setText(calendar.getTime());
        holder.icon.setImageResource(calendar.getIconResId());
    }

    @Override
    public int getItemCount() {
        return calendarList.size();
    }

    public static class CalendarViewHolder extends RecyclerView.ViewHolder {
        TextView title, time;
        ImageView icon;

        public CalendarViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleText);
            time = itemView.findViewById(R.id.timeText);
            icon = itemView.findViewById(R.id.iconImage);
        }
    }
}
