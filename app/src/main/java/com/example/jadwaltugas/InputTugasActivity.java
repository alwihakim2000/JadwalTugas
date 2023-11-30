package com.example.jadwaltugas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputTugasActivity extends AppCompatActivity {

    EditText input_nama_mk, input_nama_tugas, input_deadline, input_keterangan;
    Button buttonSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_tugas);

        input_nama_mk = findViewById(R.id.editTextNamaHari);
        input_nama_tugas = findViewById(R.id.editTextNamaMataKuliah);
        input_deadline = findViewById(R.id.editTextDeadline);
        input_keterangan = findViewById(R.id.editTextDetailTugas);
        buttonSimpan = findViewById(R.id.buttonSimpan);
        buttonSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper DB = new DatabaseHelper(InputTugasActivity.this);
                DB.tambahTugas(input_nama_mk.getText().toString().trim(),
                        input_nama_tugas.getText().toString().trim(),
                        input_deadline.getText().toString().trim(),
                        input_keterangan.getText().toString().trim());
                kembaliKeMainActivity();
            }
        });
    }
    private void kembaliKeMainActivity() {
        Intent intent = new Intent(InputTugasActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Menutup activity saat ini agar tidak dapat dikembalikan dengan tombol back
    }
}