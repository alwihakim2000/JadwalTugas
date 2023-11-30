package com.example.jadwaltugas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class TugasActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TugasAdapter tugasAdapter;
    DatabaseHelper DBHelper;
    ArrayList<String> tugas_id, tugas_nama_mk, tugas_namaTugas, tugas_deadline, tugas_keterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas);

        FloatingActionButton tambahTugas = findViewById(R.id.tambahTugas);
        tambahTugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TugasActivity.this, InputTugasActivity.class);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.recycler_view_tugas);
        DBHelper = new DatabaseHelper(TugasActivity.this);
        tugas_id = new ArrayList<>();
        tugas_nama_mk = new ArrayList<>();
        tugas_namaTugas = new ArrayList<>();
        tugas_deadline = new ArrayList<>();
        tugas_keterangan = new ArrayList<>();

        storeDataInArrays();
        tugasAdapter = new TugasAdapter(TugasActivity.this, this, tugas_id, tugas_nama_mk, tugas_namaTugas, tugas_deadline, tugas_keterangan);
        recyclerView.setAdapter(tugasAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(TugasActivity.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void storeDataInArrays(){
        Cursor cursor = DBHelper.readDataTugas();
        while (cursor.moveToNext()){
            tugas_id.add(cursor.getString(0));
            tugas_nama_mk.add(cursor.getString(1));
            tugas_namaTugas.add(cursor.getString(2));
            tugas_deadline.add(cursor.getString(3));
            tugas_keterangan.add(cursor.getString(4));
        }
    }
}