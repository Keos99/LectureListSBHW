package com.example.lecturelist.model;

import androidx.recyclerview.widget.RecyclerView;
import com.example.lecturelist.adapters.MainActivityViewHolderFactory;

public class LectureItem implements RowType {

    private final int mNumber;
    private final String mDate;
    private final String mTheme;
    private final String mLector;

    public LectureItem(int mNumber, String mDate, String mTheme, String mLector) {
        this.mNumber = mNumber;
        this.mDate = mDate;
        this.mTheme = mTheme;
        this.mLector = mLector;
    }

    public String getLector() {
        return mLector;
    }

    public String getDate() {
        return mDate;
    }

    @Override
    public int getItemViewType() {
        return RowType.LECTURE_ROW_TYPE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder) {
        MainActivityViewHolderFactory.LectureHolder lectureHolder =
                (MainActivityViewHolderFactory.LectureHolder) viewHolder;
        lectureHolder.getDate().setText(mDate);
        lectureHolder.getTheme().setText(mTheme);
        lectureHolder.getLector().setText(mLector);
        lectureHolder.getNumber().setText(mNumber);
    }
}
