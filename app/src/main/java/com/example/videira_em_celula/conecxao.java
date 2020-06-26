package com.example.videira_em_celula;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class conecxao extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 3;
    public conecxao( Context context) {
        super(context, name, null, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table membro(id integer Primary Key autoincrement,"+
                "nome varchar(50),email varchar(40),telefone varchar(15),endereco varchar(40),idade varchar(11),batizado varchar(3))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
