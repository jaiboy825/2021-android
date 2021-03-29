package com.example.sm3_29;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nameView, phoneView, emailView;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBtn = findViewById(R.id.btn);
        nameView = findViewById(R.id.name);
        phoneView = findViewById(R.id.phone);
        emailView = findViewById(R.id.email);

        addBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == addBtn) {
            String name = nameView.getText().toString();
            String email = emailView.getText().toString();
            String phone = phoneView.getText().toString();

            if (name == null || name.equals("")) {
                Toast.makeText(this, "이름이 입력되지 않았습니다", Toast.LENGTH_LONG).show();
            }else {
                DBHelper helper = new DBHelper(this);
                SQLiteDatabase db = helper.getWritableDatabase();
                db.execSQL("insert into contactDB(name,phone,email) values(?,?,?)", new String[]{name, phone, email});
                db.close();
                Toast.makeText(this, "새로운 주소록이 등록되었습니다", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, misson_result.class);
                startActivity(intent);
            }
        }
    }
}