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

public class TampilanTugas extends AppCompatActivity {

    TextView tvtugas_nama_tugas, tvtugas_nama_mk, tvtugas_deadline, tvtugas_keterangan;
    String id, nama_tugas, nama_mk, deadline, keterangan;
    Button delete_button, back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_tugas);

        tvtugas_nama_tugas = findViewById(R.id.textViewNamaTugas);
        tvtugas_nama_mk = findViewById(R.id.textViewNamaMK);
        tvtugas_deadline = findViewById(R.id.textViewDeadline);
        tvtugas_keterangan = findViewById(R.id.textViewKeterangan);
        delete_button = findViewById(R.id.delete_button);
        back_button = findViewById(R.id.back_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(nama_tugas);
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
                Intent intent = new Intent(TampilanTugas.this, TugasActivity.class);
                startActivity(intent);
            }
        });
    }
    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("nama_tugas") &&
                getIntent().hasExtra("nama_mk") && getIntent().hasExtra("deadline")
                && getIntent().hasExtra("keterangan")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            nama_tugas = getIntent().getStringExtra("nama_tugas");
            nama_mk = getIntent().getStringExtra("nama_mk");
            deadline = getIntent().getStringExtra("deadline");
            keterangan = getIntent().getStringExtra("keterangan");

            //Setting Intent Data
            tvtugas_nama_tugas.setText(nama_tugas);
            tvtugas_nama_mk.setText(nama_mk);
            tvtugas_deadline.setText(deadline);
            tvtugas_keterangan.setText(keterangan);
            Log.d("stev", nama_tugas+" "+nama_mk+" "+deadline+" "+keterangan);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + nama_tugas + " ?");
        builder.setMessage("Are you sure you want to delete " + nama_tugas + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatabaseHelper myDB = new DatabaseHelper(TampilanTugas.this);
                myDB.deleteOneRowTugas(id);
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