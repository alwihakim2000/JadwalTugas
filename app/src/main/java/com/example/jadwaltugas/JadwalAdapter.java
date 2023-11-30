package com.example.jadwaltugas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.JadwalViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList jadwal_id, jadwal_nama_mata_kuliah, jadwal_hari, jadwal_jam, jadwal_ruangan, jadwal_jumlah_sks;

    public JadwalAdapter(Activity activity, Context context, ArrayList jadwal_id, ArrayList jadwal_nama_mata_kuliah,
                         ArrayList jadwal_hari, ArrayList jadwal_jam, ArrayList jadwal_ruangan, ArrayList jadwal_jumlah_sks) {
        this.activity = activity;
        this.context = context;
        this.jadwal_id = jadwal_id;
        this.jadwal_nama_mata_kuliah = jadwal_nama_mata_kuliah;
        this.jadwal_hari = jadwal_hari;
        this.jadwal_jam = jadwal_jam;
        this.jadwal_ruangan = jadwal_ruangan;
        this.jadwal_jumlah_sks = jadwal_jumlah_sks;
    }

    @NonNull
    @Override
    public JadwalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_jadwal, parent, false);
        return new JadwalViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull JadwalViewHolder holder, int position) {
        holder.textViewNamaMataKuliah.setText(String.valueOf(jadwal_nama_mata_kuliah.get(position)));
        holder.textViewHari.setText(String.valueOf(jadwal_hari.get(position)));
        holder.textViewJam.setText(String.valueOf(jadwal_jam.get(position)));
        holder.textViewRuangan.setText(String.valueOf(jadwal_ruangan.get(position)));
        holder.textViewJumlahSKS.setText(String.valueOf(jadwal_jumlah_sks.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TampilanJadwal.class);
                intent.putExtra("id", String.valueOf(jadwal_id.get(position)));
                intent.putExtra("nama_mk", String.valueOf(jadwal_nama_mata_kuliah.get(position)));
                intent.putExtra("hari", String.valueOf(jadwal_hari.get(position)));
                intent.putExtra("jam", String.valueOf(jadwal_jam.get(position)));
                intent.putExtra("ruangan", String.valueOf(jadwal_ruangan.get(position)));
                intent.putExtra("sks", String.valueOf(jadwal_jumlah_sks.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }


    @Override
    public int getItemCount() {
        return jadwal_id.size();
    }

    class JadwalViewHolder extends RecyclerView.ViewHolder {

        TextView textViewNamaMataKuliah, textViewHari, textViewJam,
                textViewRuangan, textViewJumlahSKS;
        LinearLayout mainLayout;

        JadwalViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNamaMataKuliah = itemView.findViewById(R.id.textViewNamaMataKuliah);
            textViewHari = itemView.findViewById(R.id.textViewHari);
            textViewJam = itemView.findViewById(R.id.textViewJam);
            textViewRuangan = itemView.findViewById(R.id.textViewRuangan);
            textViewJumlahSKS = itemView.findViewById(R.id.textViewJumlahSKS);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}

