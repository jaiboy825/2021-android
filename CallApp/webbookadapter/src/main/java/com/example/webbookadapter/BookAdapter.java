package com.example.webbookadapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<BookVO> {
    Context context;
    int resId;
    ArrayList<BookVO> datas;

    public BookAdapter(Context context, int resource, ArrayList<BookVO> objects) {
        super(context, resource);
        this.context = context;
        this.resId = resource;
        this.datas = objects;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);

            BookHolder holder = new BookHolder(convertView);
            convertView.setTag(holder);
        }
        BookHolder holder = (BookHolder) convertView.getTag();
        TextView titleView = holder.titleView;
        TextView infoView = holder.infoView;
        ImageView downloadView = holder.downImageView;

        final BookVO vo = datas.get(position);
        titleView.setText(vo.title);
        infoView.setText(vo.info);
        downloadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, vo.title + "화를 보여드립니다.", Toast.LENGTH_SHORT).show();

            }
        });
        return convertView;
    }
}
