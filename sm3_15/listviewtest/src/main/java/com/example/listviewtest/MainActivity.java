package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        ArrayList<ListItem> items = new ArrayList<ListItem>();
        items.add(new ListItem("icon", "홍길동", "잘지내시죠"));
        items.add(new ListItem("icon2", "김길동", "잘지내시죠;;"));
        items.add(new ListItem("icon3", "코길동", "잘지내시죠~~"));
        items.add(new ListItem("icon", "야길동", "잘지내시죠!!"));
        items.add(new ListItem("icon2", "신길동", "잘지내시죠~!"));
        items.add(new ListItem("icon3", "안길동", "잘지내시죠!~"));
        items.add(new ListItem("icon", "이길동", "잘지내시죠~!@"));
        items.add(new ListItem("icon2", "한길동", "잘지내시죠@##!@#"));
        items.add(new ListItem("icon3", "전길동", "잘지내시죠$#@!$#@"));
        MyAdapter myAdapter = new MyAdapter(items);
        listView.setAdapter(myAdapter);
    }
}