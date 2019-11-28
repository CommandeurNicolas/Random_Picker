package com.example.randompicker.bdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static final String TAG = "Database";

    private static final String TABLE_NAME = "events";
    private static final String COLUMN_0 = "id_action";
    private static final String COLUMN_1 = "text";

    public Database(Context context){
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_1 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_1 ,item);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getText() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT "+ COLUMN_1 + " FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getItemID(String act) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COLUMN_0 + " FROM " + TABLE_NAME + " WHERE " + COLUMN_1 + " = '" + act + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void deleteItem(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_1 + " = '" + name + "'");
    }
}