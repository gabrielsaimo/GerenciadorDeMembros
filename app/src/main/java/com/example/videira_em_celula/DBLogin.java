package com.example.videira_em_celula;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class DBLogin extends SQLiteOpenHelper {

    private static int version = 1;
    private static String nome="Login_registro.db";

    public DBLogin(@Nullable Context context) {
        super(context, nome, null, version);
    }

    public DBLogin(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public DBLogin(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String string = "CREATE TABLE Utilizador(Email TEXT PRIMARY KEY, password TEXT);";
        db.execSQL(string);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Utlizador;");
        onCreate(db);
    }
    public  long CriarUtilizador(String email,String password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Email",email);
        contentValues.put("password",password);
        long result = db.insert("Utilizador",null,contentValues);
        return result;
    }
    public  String ValidarLogin(String email,String password){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Utilizador WHERE email=? AND password=?",new String[]{email,password});
        if (cursor.getCount()>0){
            return "OK";
        }
        return "ERRO";
}
}





























