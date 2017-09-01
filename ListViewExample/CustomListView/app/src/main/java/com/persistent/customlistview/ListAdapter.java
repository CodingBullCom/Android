package com.persistent.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pawan on 27/08/17.
 */

public class ListAdapter extends ArrayAdapter<Map<String,String>> {

    private ArrayList<Map<String,String>> mData;
    public ListAdapter(Context context, ArrayList<Map<String,String>> resources) {
        super(context, 0, resources);
        mData = resources;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        ImageView imageView = listItemView.findViewById(R.id.image_view);
        TextView titleTextView = listItemView.findViewById(R.id.title_text_view);
        TextView descriptionTextView = listItemView.findViewById(R.id.description_text_view);

        Map<String,String> map = mData.get(position);
        titleTextView.setText(map.get("title"));
        descriptionTextView.setText(map.get("url"));
        imageView.setImageResource(R.drawable.udemy);

        return listItemView;
    }


}
