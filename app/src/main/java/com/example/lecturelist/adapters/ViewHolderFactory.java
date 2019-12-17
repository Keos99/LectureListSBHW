package com.example.lecturelist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lecturelist.R;
import com.example.lecturelist.model.RowType;

public class ViewHolderFactory {

    public static class LectureHolder extends RecyclerView.ViewHolder {
        private final TextView mNumber;
        private final TextView mDate;
        private final TextView mTheme;
        private final TextView mLector;

        private LectureHolder(@NonNull View itemView) {
            super(itemView);
            mNumber = itemView.findViewById(R.id.lectures_number);
            mDate = itemView.findViewById(R.id.date);
            mTheme = itemView.findViewById(R.id.theme);
            mLector = itemView.findViewById(R.id.lector);
        }

        public TextView getNumber() {
            return mNumber;
        }

        public TextView getDate() {
            return mDate;
        }

        public TextView getTheme() {
            return mTheme;
        }

        public TextView getLector() {
            return mLector;
        }
    }

    public static class WeekHolder extends RecyclerView.ViewHolder {
        private final TextView mTextViewWeek;

        private WeekHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewWeek = itemView.findViewById(R.id.week_textview);
        }

        public TextView getTextViewWeek() {
            return mTextViewWeek;
        }
    }

    public static RecyclerView.ViewHolder create(ViewGroup parent, int viewType) {

        switch (viewType) {
            case RowType.LECTURE_ROW_TYPE:
                View lectureTypeView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_lecture, parent, false);
                return new LectureHolder(lectureTypeView);

            case RowType.WEEK_ROW_TYPE:
                View weekTypeView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_week, parent, false);
                return new WeekHolder(weekTypeView);

            default:
                return null;
        }
    }
}
