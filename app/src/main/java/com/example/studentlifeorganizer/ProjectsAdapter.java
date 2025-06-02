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

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder> {

    public interface OnItemClickListener {
        void onEditClick(int position);
        void onDeleteClick(int position);
    }

    private Context context;
    private List<Project> projectList;
    private OnItemClickListener listener;

    public ProjectsAdapter(Context context, List<Project> projectList, OnItemClickListener listener) {
        this.context = context;
        this.projectList = projectList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_project, parent, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        Project project = projectList.get(position);
        holder.projectName.setText(project.getName());
        holder.teacherName.setText(project.getTeacherName());
        holder.projectDate.setText(project.getDate());
        holder.hallName.setText(project.getHall());
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

    class ProjectViewHolder extends RecyclerView.ViewHolder {

        TextView projectName, teacherName, projectDate, hallName;
        ImageButton buttonEdit, buttonDelete;

        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);

            projectName = itemView.findViewById(R.id.text_project_name);
            teacherName = itemView.findViewById(R.id.text_teacher_name);
            projectDate = itemView.findViewById(R.id.text_project_date);
            hallName = itemView.findViewById(R.id.text_hall_name);
            buttonEdit = itemView.findViewById(R.id.button_edit);
            buttonDelete = itemView.findViewById(R.id.button_delete);

            buttonEdit.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onEditClick(position);
                }
            });

            buttonDelete.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onDeleteClick(position);
                }
            });
        }
    }
}
