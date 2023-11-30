package com.example.jadwaltugas;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Array;
import java.util.ArrayList;

public class JadwalActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    JadwalAdapter jadwalAdapter;
    DatabaseHelper DBHelper;
    ArrayList<String> jadwal_id, jadwal_nama_mata_kuliah, jadwal_hari,
            jadwal_jam, jadwal_ruangan, jadwal_jumlah_sks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);

        FloatingActionButton tambahJadwal = findViewById(R.id.tambahJadwal);
        tambahJadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JadwalActivity.this, InputJadwalActivity.class);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.recycler_view_jadwal);
        DBHelper = new DatabaseHelper(JadwalActivity.this);
        jadwal_id = new ArrayList<>();
        jadwal_nama_mata_kuliah = new ArrayList<>();
        jadwal_hari = new ArrayList<>();
        jadwal_jam = new ArrayList<>();
        jadwal_ruangan = new ArrayList<>();
        jadwal_jumlah_sks = new ArrayList<>();

        storeDataInArrays();
        jadwalAdapter = new JadwalAdapter(JadwalActivity.this, this, jadwal_id,
                jadwal_nama_mata_kuliah, jadwal_hari, jadwal_jam, jadwal_ruangan, jadwal_jumlah_sks);
        recyclerView.setAdapter(jadwalAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(JadwalActivity.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void storeDataInArrays(){
        Cursor cursor = DBHelper.readDataJadwal();
        while (cursor.moveToNext()){
            jadwal_id.add(cursor.getString(0));
            jadwal_nama_mata_kuliah.add(cursor.getString(1));
            jadwal_hari.add(cursor.getString(2));
            jadwal_jam.add(cursor.getString(3));
            jadwal_ruangan.add(cursor.getString(4));
            jadwal_jumlah_sks.add(cursor.getString(5));
        }
    }

}


