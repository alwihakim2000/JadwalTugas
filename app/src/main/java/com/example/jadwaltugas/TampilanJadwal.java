package com.example.jadwaltugas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TampilanJadwal extends AppCompatActivity {

    TextView tvjadwal_nama_mk, tvjadwal_hari, tvjadwal_jam, tvjadwal_ruangan, tvjadwal_sks;
    String id, nama_mk, hari, jam, ruangan, sks;
    Button delete_button, back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_jadwal);

        tvjadwal_nama_mk = findViewById(R.id.textViewNamaMataKuliah);
        tvjadwal_hari = findViewById(R.id.textViewHari);
        tvjadwal_jam = findViewById(R.id.textViewJam);
        tvjadwal_ruangan = findViewById(R.id.textViewRuangan);
        tvjadwal_sks = findViewById(R.id.textViewJumlahSKS);
        delete_button = findViewById(R.id.delete_button);
        back_button = findViewById(R.id.back_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(nama_mk);
        }
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TampilanJadwal.this, JadwalActivity.class);
                startActivity(intent);
            }
        });
    }
    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("nama_mk") &&
                getIntent().hasExtra("hari") && getIntent().hasExtra("jam")
                && getIntent().hasExtra("ruangan") && getIntent().hasExtra("sks")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            nama_mk = getIntent().getStringExtra("nama_mk");
            hari = getIntent().getStringExtra("hari");
            jam = getIntent().getStringExtra("jam");
            ruangan = getIntent().getStringExtra("ruangan");
            sks = getIntent().getStringExtra("sks");

            //Setting Intent Data
            tvjadwal_nama_mk.setText(nama_mk);
            tvjadwal_hari.setText(hari);
            tvjadwal_jam.setText(jam);
            tvjadwal_ruangan.setText(ruangan);
            tvjadwal_sks.setText(sks);
            Log.d("stev", nama_mk+" "+hari+" "+jam+" "+ruangan+" "+sks);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + nama_mk + " ?");
        builder.setMessage("Are you sure you want to delete " + nama_mk + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatabaseHelper myDB = new DatabaseHelper(TampilanJadwal.this);
                myDB.deleteOneRowJadwal(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}