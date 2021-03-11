package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트뷰 테스트");
        ListView listView = findViewById(R.id.listView);
        ArrayList<String> dataArr = new ArrayList<String>();

        dataArr.add("java");
        dataArr.add("24시");
        dataArr.add("로스트");
        dataArr.add("jsp");
        dataArr.add("안드로이드");
        dataArr.add("탐정몽크");
        dataArr.add("빅뱅");
        dataArr.add("프렌즈");
        dataArr.add("덱스터");
        dataArr.add("빈센조");
        dataArr.add("test");
        dataArr.add("테이큰");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataArr);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, dataArr.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mainmenu, menu);
        return true;
    }
}