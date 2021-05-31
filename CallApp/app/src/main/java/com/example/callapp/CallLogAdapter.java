package com.example.callapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;

public class CallLogAdapter extends ArrayAdapter<CallLogVO> {
    Context context;
    int resId;
    ArrayList<CallLogVO> datas;

    public CallLogAdapter(Context context, int resource,ArrayList<CallLogVO> objects) {
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
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);

            CallLogHolder holder = new CallLogHolder(convertView);
            convertView.setTag(holder);
        }
        CallLogHolder holder = (CallLogHolder) convertView.getTag();
        ImageView personImageView = holder.personImageView;
        TextView nameView = holder.nameView;
        TextView dateView = holder.dateView;
        ImageView dialerImageView = holder.dialerImageView;

        final CallLogVO vo = datas.get(position);
        nameView.setText(vo.name);
        dateView.setText(vo.date);

        if (vo.photo != null && vo.photo.equals("yes")){
            personImageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.hong, null));
        }else{
            personImageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_person, null));
        }

        if(vo.phone != null && !vo.phone.equals("")){
            dialerImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + vo.phone));
                    context.startActivity(intent);

                }
            });
        }
        return convertView;
    }
}
