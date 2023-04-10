package com.example.uts_bandara;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context ctx;
    private static final String DATABASE_NAME = "db_bandara_0060";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "tbl_bandara_0060";
    private static final String FIELD_ID = "field_id";
    private static final String FIELD_NAMA = "field_nama";
    private static final String FIELD_KOTA = "field_kota";
    private static final String FIELD_ALAMAT = "field_alamat";
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.ctx = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                FIELD_NAMA + " VARCHAR(50)," +
                FIELD_KOTA + " VARCHAR(50)," +
                FIELD_ALAMAT + " VARCHAR(50)" +
                ")"
                ;
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        onCreate(db);
    }
    public long tambahDataBandara(String field_nama, String field_kota, String field_alamat)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(FIELD_NAMA, field_nama);
        cv.put(FIELD_KOTA, field_kota);
        cv.put(FIELD_ALAMAT, field_alamat);
        long exe = db.insert(TABLE_NAME, null, cv);
        return exe;
    }
    public Cursor bacaDataBandara(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

}
