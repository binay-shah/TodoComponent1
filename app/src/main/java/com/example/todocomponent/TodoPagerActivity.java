package com.example.todocomponent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.UUID;

public class TodoPagerActivity extends AppCompatActivity {

    private static final String EXTRA_TODO_ID = "todo_id";
    public static final String TAG = TodoPagerActivity.class.getSimpleName();
    private ViewPager2 viewPager;
    private ArrayList<Todo> todosList;

    private TodoModel todoModel;

    public static Intent makeIntent(Context context, UUID todoId){
        Intent intent = new Intent(context, TodoPagerActivity.class);
        intent.putExtra(EXTRA_TODO_ID, todoId);
        return intent;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_pager);

        Intent intent = getIntent();
        UUID todoId = (UUID) intent.getSerializableExtra(EXTRA_TODO_ID);
        Log.d(TAG, ""+todoId);

        todoModel = TodoModel.getInstance();
        todosList = todoModel.getTodosList();

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                Todo todo = todosList.get(position);
                return TodoFragment.newInstance(todo.getId());
            }

            @Override
            public int getItemCount() {
                return todosList.size();
            }
        });
    }
}