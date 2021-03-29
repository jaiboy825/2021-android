package com.example.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class ReadDBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_d_b);
        TextView titleView = findViewById(R.id.result_title);
        TextView contentsView = findViewById(R.id.result_contents);
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select title, contents from memo_db order by _id desc limit 1", null);
        while (cursor.moveToNext()){
            titleView.setText(cursor.getString(0));
            contentsView.setText(cursor.getString(1));
        }
        db.close();
    }
}