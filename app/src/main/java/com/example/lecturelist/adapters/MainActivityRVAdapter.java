package com.example.lecturelist.adapters;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lecturelist.model.RowType;
import java.util.List;

public class MainActivityRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<RowType> mDataSet;

    public MainActivityRVAdapter(List<RowType> mDataSet) {
        this.mDataSet = mDataSet;
    }

    @Override
    public int getItemViewType(int position) {
        return mDataSet.get(position).getItemViewType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MainActivityViewHolderFactory.create(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        mDataSet.get(position).onBindViewHolder(holder);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public int getPositionOf(RowType item) {
        return mDataSet.indexOf(item);
    }


}
