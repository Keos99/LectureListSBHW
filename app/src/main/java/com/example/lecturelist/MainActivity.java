package com.example.lecturelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.lecturelist.adapters.AdapterLectorsSpinner;
import com.example.lecturelist.adapters.AdapterRecyclerView;
import com.example.lecturelist.datadaprovider.DataProvider;

import java.util.Date;
import java.util.List;

import static com.example.lecturelist.properties.Properties.POSITION_ALL;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Spinner mLectorsSpinner;
    private Spinner mWeekSpinner;
    private DataProvider mDataProvider;
    private AdapterRecyclerView mAdapter;
    private AdapterLectorsSpinner mAdapterLectorsSpinner;
    private List<String> mItemsLectorsSpiner;
    private ArrayAdapter mAdapterWeekLekture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initUI();
        actualLecture(savedInstanceState == null);
    }

    private void initData() {
        mDataProvider = new DataProvider(this);
    }

    private void initUI() {
        mRecyclerView = findViewById(R.id.recyclerview_main_activity);
        mLectorsSpinner = findViewById(R.id.main_activity_lectors_spinner);
        mWeekSpinner = findViewById(R.id.main_activity_display_mode_spinner);
        initRecyclerView();
        initLectorSpiner();
        initWeekSpinner();
    }

    private void initRecyclerView() {
        mAdapter = new AdapterRecyclerView(mDataProvider.getLectures());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }

    private void initLectorSpiner() {
        mItemsLectorsSpiner = mDataProvider.providerLectors();
        mAdapterLectorsSpinner = new AdapterLectorsSpinner(this,
                android.R.layout.simple_spinner_dropdown_item, mItemsLectorsSpiner);
        mLectorsSpinner.setAdapter(mAdapterLectorsSpinner);
        initLectorsOnClick();
    }

    private void initLectorsOnClick() {
        mLectorsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == POSITION_ALL) {
                    mAdapter.setDataSet(mDataProvider.getLectures());
                } else {
                    mAdapter.setDataSet(mDataProvider.filterBy(mItemsLectorsSpiner.get(position)));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initWeekSpinner() {
        mAdapterWeekLekture = ArrayAdapter.createFromResource(this, R.array.weakspinner,
                android.R.layout.simple_spinner_dropdown_item);
        mAdapterWeekLekture.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mWeekSpinner.setAdapter(mAdapterWeekLekture);
        initWeekSpinnerOnClick();
    }

    private void initWeekSpinnerOnClick() {
        mWeekSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == POSITION_ALL) {
                    mAdapter.setDataSet(mDataProvider.getLectures());
                } else {
                    mAdapter.setDataSet(mDataProvider.groupByWeek());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void actualLecture(boolean isFirstCreate) {
        if (isFirstCreate) {
            int nextPosition = mAdapter.getPositionOf(mDataProvider.getCloseLection(new Date()));
            if (nextPosition != -1) {
                mRecyclerView.scrollToPosition(nextPosition);
            }
        }
    }
}
