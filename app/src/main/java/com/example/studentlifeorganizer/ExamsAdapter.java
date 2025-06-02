package com.example.studentlifeorganizer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExamsAdapter extends RecyclerView.Adapter<ExamsAdapter.ExamViewHolder> {

    public interface OnItemClickListener {
        void onAddClick(int position);
        void onDeleteClick(int position);
    }

    private Context context;
    private List<Exam> examList;
    private OnItemClickListener listener;

    public ExamsAdapter(Context context, List<Exam> examList, OnItemClickListener listener) {
        this.context = context;
        this.examList = examList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_exam, parent, false);
        return new ExamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamViewHolder holder, int position) {
        Exam exam = examList.get(position);
        holder.examName.setText(exam.getExamName());
        holder.teacherName.setText(exam.getTeacherName());
        holder.hallNumber.setText(exam.getHallNumber());
        holder.time.setText(exam.getTime());
        holder.date.setText(exam.getDate());
    }

    @Override
    public int getItemCount() {
        return examList.size();
    }

    class ExamViewHolder extends RecyclerView.ViewHolder {

        TextView examName, teacherName, hallNumber, time, date;
        ImageButton buttonDelete, buttonAdd;

        public ExamViewHolder(@NonNull View itemView) {
            super(itemView);

            examName = itemView.findViewById(R.id.text_exam_name);
            teacherName = itemView.findViewById(R.id.text_teacher_name);
            hallNumber = itemView.findViewById(R.id.text_hall_number);
            time = itemView.findViewById(R.id.text_time);
            date = itemView.findViewById(R.id.text_date);

            buttonDelete = itemView.findViewById(R.id.button_delete);
            buttonAdd = itemView.findViewById(R.id.button_add);

            buttonDelete.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onDeleteClick(position);
                }
            });

            buttonAdd.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onAddClick(position);
                }
            });
        }
    }
}
