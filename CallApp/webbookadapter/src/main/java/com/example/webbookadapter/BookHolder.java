package com.example.webbookadapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BookHolder {

    public TextView titleView;
    public TextView infoView;
    public ImageView downImageView;
    public ImageView personImageView;

    public BookHolder(View root){
    titleView = root.findViewById(R.id.item_title);
    infoView = root.findViewById(R.id.item_info);
    downImageView = root.findViewById(R.id.item_download);
    personImageView = root.findViewById(R.id.main_item_person);
    }
}
