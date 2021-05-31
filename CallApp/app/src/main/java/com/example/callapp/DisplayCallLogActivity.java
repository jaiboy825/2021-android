package com.example.callapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DisplayCallLogActivity extends AppCompatActivity {
    EditText editName, editDate, editPhone;

    Button btnSave, btnUpdate, btnDelete;

    Boolean isNew;
    int itemId;

    DBHelper helper;
    SQLiteDatabase db;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_call_log);
        editName = findViewById(R.id.editName);
        editDate = findViewById(R.id.editDate);
        editPhone = findViewById(R.id.editPhone);

        btnSave = findViewById(R.id.btnSave);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);

        helper = new DBHelper(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            isNew = extras.getBoolean("isNew");
            if(isNew) {
                btnUpdate.setVisibility(View.INVISIBLE);
                btnDelete.setVisibility(View.INVISIBLE);
            }else {
                btnSave.setVisibility(View.INVISIBLE);
                itemId = extras.getInt("id");
                db = helper.getReadableDatabase();

                String strSQL = "select name, date, phone from tb_calllog where _id =" + Integer.toString(itemId) + ";";
                cursor = db.rawQuery(strSQL, null);
                CallLogVO vo = new CallLogVO();
                while(cursor.moveToNext()){
                    vo.id = cursor.getInt(0);
                    vo.name = cursor.getString(1);
                    vo.photo = cursor.getString(2);
                }
                editName.setText(vo.name);
                editDate.setText(vo.date);
                editPhone.setText(vo.phone);
                db.close();
            }
        }
    }

    public void save(View view){
        String name = editName.getText().toString();
        String date = editDate.getText().toString();
        String phone = editPhone.getText().toString();
        String strSql;

        db = helper.getWritableDatabase();

        db.execSQL("insert into tbl_calllog (name, phone, date, phone) values (?,?,?,?)", new String[]{name, "yes", date, phone});
        db.close();

        Toast.makeText(getApplicationContext(), "DB에 연락처가 추가되었습니다", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void update(View view){
        String name = editName.getText().toString();
        String date = editDate.getText().toString();
        String phone = editPhone.getText().toString();
        String strSql;

        db = helper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("date", date);
        contentValues.put("phone", phone);

        db.execSQL("insert into tbl_calllog (name, phone, date, phone) values (?,?,?,?)", new String[]{name, "yes", date, phone});
        db.close();

        Toast.makeText(getApplicationContext(), "DB에" + name+"의 연락처가 수정되었습니다", Toast.LENGTH_SHORT).show();
        finish();
    }
}