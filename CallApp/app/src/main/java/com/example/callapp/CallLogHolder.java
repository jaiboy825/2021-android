package com.example.callapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CallLogHolder {

    public ImageView personImageView;
    public TextView nameView;
    public TextView dateView;
    public ImageView dialerImageView;

    public CallLogHolder(View root){
    personImageView = root.findViewById(R.id.main_item_person);
    nameView = root.findViewById(R.id.item_name);
    dateView = root.findViewById(R.id.item_date);
    dialerImageView = root.findViewById(R.id.item_dialer);
    }
}
