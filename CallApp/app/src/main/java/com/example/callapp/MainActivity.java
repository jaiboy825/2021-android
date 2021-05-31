package com.example.callapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    boolean callPermission;
    ListView listView;
    Button btnAdd;
    ArrayList<CallLogVO> datas;
    CallLogAdapter adapter;

    DBHelper helper;
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            callPermission = true;
        }

        if (!callPermission) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 200);
        }

        listView = findViewById(R.id.main_list);

        datas = new ArrayList<>();
        helper = new DBHelper(this);
        db = helper.getWritableDatabase();
        cursor = db.rawQuery("select _id, name, photo, date, phone from tb_calllog", null);
        while (cursor.moveToNext()) {
            CallLogVO vo = new CallLogVO();
            vo.id = cursor.getInt(0);
            vo.name = cursor.getString(1);
            vo.photo = cursor.getString(2);
            vo.date = cursor.getString(3);
            vo.phone = cursor.getString(4);
            datas.add(vo);
        }
        db.close();

        adapter = new CallLogAdapter(this, R.layout.main_list_item, datas);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final CallLogVO vo = datas.get(i);
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", vo.id);
                dataBundle.putBoolean("isNew", false);
                Intent intent = new Intent(getApplicationContext(), DisplayCallLogActivity.class);
                intent.putExtra(dataBundle);
                startActivity(intent);
            }
        });

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", 0);
                dataBundle.putBoolean("isNew", false);
                Intent intent = new Intent(getApplicationContext(), DisplayCallLogActivity.class);
                intent.putExtra(dataBundle);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        datas.clear();
        helper = new DBHelper(this);
        db = helper.getReadableDatabase();
        cursor = db.rawQuery("select _id, name, photo, date, phone from tb_calllog", null);
        while(cursor.moveToNext()){
            CallLogVO vo = new CallLogVO();
            vo.id = cursor.getInt(0);
            vo.name = cursor.getString(1);
            vo.photo = cursor.getString(2);
            vo.date = cursor.getString(3);
            vo.phone = cursor.getString(4);
            datas.add(vo);
        }
        db.close();
        adapter.addAll(datas);
        adapter.notifyDataSetChanged();

    }
}