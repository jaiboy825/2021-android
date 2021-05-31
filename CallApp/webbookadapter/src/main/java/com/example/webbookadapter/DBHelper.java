package com.example.webbookadapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, "webbookDB", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableSql = "create table tb_webbook (" +
                "_id integer primary key autoincrement," +
                "title not null," +
                "info)";

        db.execSQL(tableSql);

        db.execSQL("insert into tb_webbook (title, info) values ('김 비서가 왜 그럴까 1', '2018-08-03')");
        db.execSQL("insert into tb_webbook (title, info) values ('김 비서가 왜 그럴까 2', '2018-08-04')");
        db.execSQL("insert into tb_webbook (title, info) values ('김 비서가 왜 그럴까 3', '2018-08-05')");
        db.execSQL("insert into tb_webbook (title, info) values ('김 비서가 왜 그럴까 4', '2018-08-06')");
        db.execSQL("insert into tb_webbook (title, info) values ('김 비서가 왜 그럴까 5', '2018-08-07')");
        db.execSQL("insert into tb_webbook (title, info) values ('김 비서가 왜 그럴까 6', '2018-08-08')");
        db.execSQL("insert into tb_webbook (title, info) values ('김 비서가 왜 그럴까 7', '2018-08-09')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == DATABASE_VERSION) {
            db.execSQL("drop table tb_webbook");
            onCreate(db);
        }
    }
}
