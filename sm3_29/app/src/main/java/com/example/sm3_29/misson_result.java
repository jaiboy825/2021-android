package com.example.sm3_29;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class misson_result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_misson_result);

        TextView nameView = findViewById(R.id.result_name);
        TextView phoneView = findViewById(R.id.result_phone);
        TextView emailView = findViewById(R.id.result_email);
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select name, phone, email from contactDB order by _id desc limit 1", null);
        while (cursor.moveToNext()){
            nameView.setText(cursor.getString(0));
            phoneView.setText(cursor.getString(1));
            emailView.setText(cursor.getString(2));
        }
        db.close();
    }
}