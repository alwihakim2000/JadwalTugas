package com.example.jadwaltugas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Jadwal.db";
    private static final String TABLE_JADWAL = "jadwal";
    private static final String TABLE_TUGAS = "tugas";

    // Kolom tabel jadwal
    private static final String COLUMN_ID_JADWAL = "id";
    private static final String COLUMN_NAMA_MK = "nama_mata_kuliah";
    private static final String COLUMN_HARI = "hari";
    private static final String COLUMN_JAM = "jam";
    private static final String COLUMN_RUANGAN = "ruangan";
    private static final String COLUMN_SKS = "jumlah_sks";

    // Kolom tabel tugas
    private static final String COLUMN_ID_TUGAS = "id";
    private static final String COLUMN_NAMA_MK_TUGAS = "nama_mk_tugas";
    private static final String COLUMN_NAMA_TUGAS = "nama_tugas";
    private static final String COLUMN_DEADLINE = "deadline";
    private static final String COLUMN_KETERANGAN = "keterangan";

    DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Query untuk membuat tabel jadwal
        String queryJadwal = "CREATE TABLE " + TABLE_JADWAL + "("
                + COLUMN_ID_JADWAL + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAMA_MK + " TEXT,"
                + COLUMN_HARI + " TEXT,"
                + COLUMN_JAM + " TEXT,"
                + COLUMN_RUANGAN + " TEXT,"
                + COLUMN_SKS + " INTEGER" + ")";
        db.execSQL(queryJadwal);

        // Query untuk membuat tabel tugas
        String queryTugas = "CREATE TABLE " + TABLE_TUGAS + "("
                + COLUMN_ID_TUGAS + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAMA_MK_TUGAS + " TEXT,"
                + COLUMN_NAMA_TUGAS + " TEXT,"
                + COLUMN_DEADLINE + " TEXT,"
                + COLUMN_KETERANGAN + " TEXT" + ")";
        db.execSQL(queryTugas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JADWAL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TUGAS);
        onCreate(db);
    }

    public void tambahJadwal(String mataKuliah, String hari, String jam, String ruangan, int sks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAMA_MK, mataKuliah);
        cv.put(COLUMN_HARI, hari);
        cv.put(COLUMN_JAM, jam);
        cv.put(COLUMN_RUANGAN, ruangan);
        cv.put(COLUMN_SKS, sks);

        long result = db.insert(TABLE_JADWAL,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    public void tambahTugas(String namaMk, String namaTugas, String deadline, String keterangan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAMA_MK_TUGAS, namaMk);
        cv.put(COLUMN_NAMA_TUGAS, namaTugas);
        cv.put(COLUMN_DEADLINE, deadline);
        cv.put(COLUMN_KETERANGAN, keterangan);

        long result = db.insert(TABLE_TUGAS,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readDataJadwal(){
        String query = "SELECT * FROM " + TABLE_JADWAL;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor readDataTugas(){
        String query = "SELECT * FROM " + TABLE_TUGAS;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void deleteOneRowJadwal(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_JADWAL, "id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneRowTugas(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_TUGAS, "id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }
}

