package com.example.studentlifeorganizer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link tasksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tasksFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private RecyclerView recyclerView;
    private CalendarAdapter adapter;
    private List<Calendar> calendarList;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public tasksFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tasksFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static tasksFragment newInstance(String param1, String param2) {
        tasksFragment fragment = new tasksFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tasks, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Button btnToday = view.findViewById(R.id.btn_today);
        Button btnThisWeek = view.findViewById(R.id.btn_this_week);
        Button btnNextWeek = view.findViewById(R.id.btn_next_week);
        calendarList = new ArrayList<>();
        loadTodayLectures();
        adapter = new CalendarAdapter(calendarList);
        recyclerView.setAdapter(adapter);
        btnToday.setOnClickListener(v -> {
            calendarList.clear();
            loadTodayLectures();
            adapter.notifyDataSetChanged();
        });
        btnThisWeek.setOnClickListener(v -> {
            calendarList.clear();
            loadThisWeekLectures();
            adapter.notifyDataSetChanged();
        });

        btnNextWeek.setOnClickListener(v -> {
            calendarList.clear();
            loadNextWeekLectures();
            adapter.notifyDataSetChanged();
        });
        

        return view;
        

    }

    private void loadTodayLectures() {
        calendarList.add(new Calendar("Android", "8am - 9am", R.drawable.google));
        calendarList.add(new Calendar("laravel", "9am - 10am", R.drawable.img_1));
    }

    private void loadThisWeekLectures() {
        calendarList.add(new Calendar("Android", "8am - 9am", R.drawable.google));
        calendarList.add(new Calendar("laravel", "9am - 10am", R.drawable.img_1));
        calendarList.add(new Calendar("ios", "10am - 11am", R.drawable.apple));
        calendarList.add(new Calendar("web", "10am - 11am", R.drawable.img_1));
    }

    private void loadNextWeekLectures() {
        calendarList.add(new Calendar("ios", "8am - 9am", R.drawable.apple));
        calendarList.add(new Calendar("web", "9am - 10am", R.drawable.img_1));
    }


}

