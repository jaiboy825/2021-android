package com.example.listviewtest;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseAdapter {

    private final List<ListItem> items;
    private Map<String, Integer> iconImage;

    public MyAdapter(List<ListItem> items) {
        this.items = items;
        iconImage = new HashMap<>();
        iconImage.put("icon", R.drawable.icon);
        iconImage.put("icon2", R.drawable.ic_baseline_star_24);
        iconImage.put("icon3", R.drawable.ic_baseline_favorite_24);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_item, parent, false);

        ImageView imageView = convertView.findViewById(R.id.icon);
        TextView name = convertView.findViewById(R.id.name);
        TextView content = convertView.findViewById(R.id.content);

        ListItem listItem = items.get(position);

        imageView.setImageResource(iconImage.get(listItem.getImg()));
        name.setText(listItem.getName());
        content.setText(listItem.getContent());

        return convertView;
    }
}
