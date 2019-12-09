package com.example.lecturelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lecturelist.adapters.MainActivityRVAdapter;
import com.example.lecturelist.datadaprovider.MainActivityRVDataProvider;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainActivityRVAdapter adapter;
    private MainActivityRVDataProvider dataProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initUI();
    }

    private void initData(){
        dataProvider = new MainActivityRVDataProvider();
        adapter = new MainActivityRVAdapter(dataProvider.getLectures());
    }

    private void initUI(){
        recyclerView = findViewById(R.id.recyclerview_main_activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }
}
