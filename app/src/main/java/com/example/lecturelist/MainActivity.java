package com.example.lecturelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Spinner;

import com.example.lecturelist.adapters.MainActivityRVAdapter;
import com.example.lecturelist.datadaprovider.MainActivityRVDataProvider;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Spinner mLectorsSpinner;
    private Spinner mDisplayModeSpinner;
    private MainActivityRVAdapter mAdapter;
    private MainActivityRVDataProvider mDataProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initUI();
        actualLecture(savedInstanceState == null);
    }

    private void initData(){
        mDataProvider = new MainActivityRVDataProvider();
        mAdapter = new MainActivityRVAdapter(mDataProvider.getLectures());
    }

    private void initUI(){
        mRecyclerView = findViewById(R.id.recyclerview_main_activity);
        mLectorsSpinner = findViewById(R.id.main_activity_lectors_spinner);
        mDisplayModeSpinner = findViewById(R.id.main_activity_display_mode_spinner);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }

    private void actualLecture(boolean isFirstCreate){
        if (isFirstCreate) {
            int nextPosition = mAdapter.getPositionOf(mDataProvider.getCloseLection(new Date()));
            if (nextPosition != -1) {
                mRecyclerView.scrollToPosition(nextPosition);
            }
        }
    }
}
