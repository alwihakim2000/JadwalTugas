package com.example.jadwaltugas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InputJadwalActivity extends AppCompatActivity {

    EditText input_nama_mk, input_hari, input_jam, input_ruangan, input_sks;
    Button buttonSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_jadwal);

        input_nama_mk = findViewById(R.id.editTextNamaMataKuliah);
        input_hari = findViewById(R.id.editTextNamaHari);
        input_jam = findViewById(R.id.editTextJam);
        input_ruangan = findViewById(R.id.editTextRuangan);
        input_sks = findViewById(R.id.editTextJumlahSKS);
        buttonSimpan = findViewById(R.id.buttonSimpan);
        buttonSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper DB = new DatabaseHelper(InputJadwalActivity.this);
                DB.tambahJadwal(input_nama_mk.getText().toString().trim(),
                        input_hari.getText().toString().trim(),
                        input_jam.getText().toString().trim(),
                        input_ruangan.getText().toString().trim(),
                        Integer.valueOf(input_sks.getText().toString().trim()));
                kembaliKeMainActivity();
            }
        });
    }
    private void kembaliKeMainActivity() {
        Intent intent = new Intent(InputJadwalActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Menutup activity saat ini agar tidak dapat dikembalikan dengan tombol back
    }
}
