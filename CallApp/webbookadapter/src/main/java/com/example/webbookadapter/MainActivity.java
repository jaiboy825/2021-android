package com.example.webbookadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<BookVO> datas;
    BookAdapter adapter;

    DBHelper helper;
    SQLiteDatabase db;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.main_list);

        datas = new ArrayList<>();
        helper = new DBHelper(this);
        db = helper.getWritableDatabase();
        cursor = db.rawQuery("select _id, title, info from tb_webbook", null);
        while (cursor.moveToNext()) {
            BookVO vo = new BookVO();
            vo.id = cursor.getInt(0);
            vo.title = cursor.getString(1);
            vo.info = cursor.getString(2);
            datas.add(vo);
        }
        db.close();

        adapter = new BookAdapter(this, R.layout.main_list_item, datas);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DisplayBookActivity.class);
                startActivity(intent);
            }
        });
    }
}