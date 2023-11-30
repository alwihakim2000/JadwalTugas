package com.example.jadwaltugas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("profile_data", Context.MODE_PRIVATE);

        // Tampilkan data dari SharedPreferences ke TextView di MainActivity
        TextView textViewNIM = findViewById(R.id.textViewNIM);
        textViewNIM.setText(sharedPreferences.getString("nim", ""));

        TextView textViewNama = findViewById(R.id.textViewNama);
        textViewNama.setText(sharedPreferences.getString("nama", ""));
    }
    public void openJadwalActivity(View view) {
        Intent intent = new Intent(this, JadwalActivity.class);
        startActivity(intent);
    }

    public void openTugasActivity(View view) {
        Intent intent = new Intent(this, TugasActivity.class);
        startActivity(intent);
    }

    public void openProfilActivity(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}