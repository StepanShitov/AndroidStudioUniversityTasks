package com.example.a1lab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class resultsListAdapter extends ArrayAdapter<result>
{
    private Context mContext;
    private int mResourse;

    public resultsListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<result> objects) {
        super(context, resource, objects);
        mContext = context;
        mResourse = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String data = getItem(position).get_result();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResourse, parent, false);
        TextView info = (TextView) convertView.findViewById(R.id.textView1);
        info.setText(data);
        return convertView;
    }
}
