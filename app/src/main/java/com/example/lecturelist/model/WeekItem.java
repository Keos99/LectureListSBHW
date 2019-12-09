package com.example.lecturelist.model;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lecturelist.adapters.MainActivityViewHolderFactory;

public class WeekItem implements RowType {

    private String text;

    public WeekItem(String text) {
        this.text = text;
    }

    @Override
    public int getItemViewType() {
        return RowType.WEEK_ROW_TYPE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder) {
        MainActivityViewHolderFactory.WeekHolder weekHolder =
                (MainActivityViewHolderFactory.WeekHolder) viewHolder;
        weekHolder.getTextViewWeek().setText(text);
    }
}
