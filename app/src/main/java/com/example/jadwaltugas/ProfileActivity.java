package com.example.jadwaltugas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sharedPreferences = getSharedPreferences("profile_data", Context.MODE_PRIVATE);

        // Tampilkan data dari SharedPreferences ke TextView di ProfileActivity
        TextView textViewNIM = findViewById(R.id.textViewNIM);
        textViewNIM.setText(sharedPreferences.getString("nim", ""));

        TextView textViewNama = findViewById(R.id.textViewNama);
        textViewNama.setText(sharedPreferences.getString("nama", ""));

        TextView textViewDosenWali = findViewById(R.id.textViewDosenWali);
        textViewDosenWali.setText(sharedPreferences.getString("dosenWali", ""));

        TextView textViewTanggalLahir = findViewById(R.id.textViewTanggalLahir);
        textViewTanggalLahir.setText(sharedPreferences.getString("tanggalLahir", ""));

        TextView textViewWargaNegara = findViewById(R.id.textViewWargaNegara);
        textViewWargaNegara.setText(sharedPreferences.getString("wargaNegara", ""));

        TextView textViewAlamat = findViewById(R.id.textViewAlamat);
        textViewAlamat.setText(sharedPreferences.getString("alamat", ""));

        TextView textViewNoTelepon = findViewById(R.id.textViewNoTelepon);
        textViewNoTelepon.setText(sharedPreferences.getString("noTelepon", ""));

        TextView textViewEmail = findViewById(R.id.textViewEmail);
        textViewEmail.setText(sharedPreferences.getString("email", ""));
    }
    public void openEditProfilActivity(View view) {
        Intent intent = new Intent(this, EditProfilActivity.class);
        startActivity(intent);
    }
}