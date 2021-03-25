package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText id = findViewById(R.id.id);
        EditText pw = findViewById(R.id.pw);
        String idString = id.getText().toString();
        String pwString = pw.getText().toString();

        if(idString.equals("admin") && pwString.equals("admin")){
            Success();
        }else if (idString.equals("") || pwString.equals("")){
            Fail_NoInput();
        }
        else{
            Fail_Incorrect();
        }
    }

    private void Fail_Incorrect() {
        Toast.makeText(this,  "아이디나 패스워드가 올바르지 않습니다", Toast.LENGTH_SHORT).show();
    }

    private void Fail_NoInput() {
        Toast.makeText(this, "아이디나 패스워드가 입력되지 않았습니다", Toast.LENGTH_SHORT).show();
    }

    private void Success() {
        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent);
    }
    
}