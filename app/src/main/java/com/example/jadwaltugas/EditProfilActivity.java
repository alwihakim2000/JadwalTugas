package com.example.jadwaltugas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;

public class EditProfilActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);

        sharedPreferences = getSharedPreferences("profile_data", Context.MODE_PRIVATE);

        Button buttonSimpan = findViewById(R.id.buttonSimpan);
        buttonSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mendapatkan nilai dari setiap TextInputEditText
                String nim = ((TextInputEditText) findViewById(R.id.editTextNIM)).getText().toString();
                String nama = ((TextInputEditText) findViewById(R.id.editTextNama)).getText().toString();
                String dosenWali = ((TextInputEditText) findViewById(R.id.editTextDosenWali)).getText().toString();
                String tanggalLahir = ((TextInputEditText) findViewById(R.id.editTextTanggalLahir)).getText().toString();
                String wargaNegara = ((TextInputEditText) findViewById(R.id.editTextWargaNegara)).getText().toString();
                String alamat = ((TextInputEditText) findViewById(R.id.editTextAlamat)).getText().toString();
                String noTelepon = ((TextInputEditText) findViewById(R.id.editTextNoTelepon)).getText().toString();
                String email = ((TextInputEditText) findViewById(R.id.editTextEmail)).getText().toString();

                // Simpan nilai-nilai ke SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("nim", nim);
                editor.putString("nama", nama);
                editor.putString("dosenWali", dosenWali);
                editor.putString("tanggalLahir", tanggalLahir);
                editor.putString("wargaNegara", wargaNegara);
                editor.putString("alamat", alamat);
                editor.putString("noTelepon", noTelepon);
                editor.putString("email", email);
                editor.apply();

                // Kembali ke ProfileActivity setelah menyimpan data
                Intent intent = new Intent(EditProfilActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}