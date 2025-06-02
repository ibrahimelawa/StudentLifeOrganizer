package com.example.studentlifeorganizer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private Context context;
    private List<Task> taskList;
    private OnTaskClickListener listener;

    public interface OnTaskClickListener {
        void onEditClick(int position);
        void onDeleteClick(int position);
    }

    public TaskAdapter(Context context, List<Task> taskList, OnTaskClickListener listener) {
        this.context = context;
        this.taskList = taskList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.tvTaskName.setText(task.getTaskName());
        holder.tvDescription.setText(task.getDescription());
        holder.tvTeacherName.setText(task.getTeacherName());
        holder.tvStartDate.setText("Start: " + task.getStartDate());
        holder.tvEndDate.setText("End: " + task.getEndDate());
        holder.tvReminder.setText("Reminder: " + (task.hasReminder() ? "Yes" : "No"));

        holder.btnDelete.setOnClickListener(v -> listener.onDeleteClick(position));
        holder.btnEdit.setOnClickListener(v -> listener.onEditClick(position));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView tvTaskName, tvDescription, tvTeacherName, tvStartDate, tvEndDate, tvReminder;
        ImageButton btnDelete, btnEdit;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTaskName = itemView.findViewById(R.id.tv_task_name);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvTeacherName = itemView.findViewById(R.id.tv_teacher_name);
            tvStartDate = itemView.findViewById(R.id.tv_start_date);
            tvEndDate = itemView.findViewById(R.id.tv_end_date);
            tvReminder = itemView.findViewById(R.id.tv_reminder);
            btnDelete = itemView.findViewById(R.id.btn_delete);
            btnEdit = itemView.findViewById(R.id.btn_edit);
        }
    }
}
