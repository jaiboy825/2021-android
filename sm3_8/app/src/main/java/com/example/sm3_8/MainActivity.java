package com.example.sm3_8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText num1, num2;
    Button add, sub, mul, div;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        result = findViewById(R.id.result);

        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int result_num = 0;
        int temp1 = Integer.parseInt(num1.getText().toString());
        int temp2 = Integer.parseInt(num2.getText().toString());
        switch (v.getId()) {
            case R.id.add:
                result_num =  temp1 + temp2;
                break;

            case R.id.sub:
                result_num = temp1 - temp2;
                break;

            case R.id.mul:
                result_num = temp1 * temp2;
                break;

            case R.id.div:
                result_num = temp1 / temp2;
                break;

        }
        result.setText("계산 결과 : " + result_num);

    }
}