package com.example.studentlifeorganizer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LectureAdapter extends RecyclerView.Adapter<LectureAdapter.LectureViewHolder> {

    private List<Lecture> lectureList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Lecture lecture);
    }

    public LectureAdapter(List<Lecture> lectureList, OnItemClickListener listener) {
        this.lectureList = lectureList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public LectureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lectures, parent, false);
        return new LectureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LectureViewHolder holder, int position) {
        Lecture lecture = lectureList.get(position);
        holder.bind(lecture, listener);
    }

    @Override
    public int getItemCount() {
        return lectureList.size();
    }

    static class LectureViewHolder extends RecyclerView.ViewHolder {
        TextView materialName, teacherName, lectureTime, hallName;

        public LectureViewHolder(@NonNull View itemView) {
            super(itemView);
            materialName = itemView.findViewById(R.id.materialName);
            teacherName = itemView.findViewById(R.id.teacherName);
            lectureTime = itemView.findViewById(R.id.lectureTime);
            hallName = itemView.findViewById(R.id.hallName);
        }

        public void bind(final Lecture lecture, final OnItemClickListener listener) {
            materialName.setText(lecture.getMaterialName());
            teacherName.setText(lecture.getTeacherName());
            lectureTime.setText(lecture.getTime());
            hallName.setText("| " + lecture.getHall());

            itemView.setOnClickListener(v -> listener.onItemClick(lecture));
        }
    }
}
