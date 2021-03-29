package com.example.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText title, contents;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.add);
        title = findViewById(R.id.title);
        contents = findViewById(R.id.contents);
        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == add){
            String title_text = title.getText().toString();
            String contents_text = contents.getText().toString();

            if(title_text == null || title_text.equals("")){
                Toast.makeText(this, "제목이 비었습니다", Toast.LENGTH_SHORT).show();
            }else{
                DBHelper helper = new DBHelper(this);
                SQLiteDatabase db = helper.getWritableDatabase();
                db.execSQL("insert into memo_db(title,contents) values(?,?)", new String[]{title_text, contents_text});
                db.close();
                Toast.makeText(this, "새로운 메모가 등록되었습니다", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, ReadDBActivity.class);
                startActivity(intent);
            }

        }
    }
}