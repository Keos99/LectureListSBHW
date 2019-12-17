package com.example.lecturelist.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterLectorsSpinner extends ArrayAdapter {

    private Context mContext;
    private int mResource;
    private List<String> mData;

    public AdapterLectorsSpinner(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
        mData = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mContext, mResource, null);
        }
        TextView textView = (TextView) convertView;
        textView.setText(mData.get(position));
        return convertView;
    }
}
