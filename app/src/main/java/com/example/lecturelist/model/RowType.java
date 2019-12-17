package com.example.lecturelist.model;

import androidx.recyclerview.widget.RecyclerView;

public interface RowType {
    int LECTURE_ROW_TYPE = 0;
    int WEEK_ROW_TYPE = 1;

    int getItemViewType();

    void onBindViewHolder(RecyclerView.ViewHolder viewHolder);
}
