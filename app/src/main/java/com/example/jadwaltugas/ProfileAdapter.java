package com.example.jadwaltugas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList tugas_id, tugas_nama_mk, tugas_namatugas, tugas_deadline, tugas_keterangan;

    public ProfileAdapter(Activity activity, Context context, ArrayList tugas_id, ArrayList tugas_nama_mk, ArrayList tugas_namatugas, ArrayList tugas_deadline, ArrayList tugas_keterangan) {
        this.activity = activity;
        this.context = context;
        this.tugas_id = tugas_id;
        this.tugas_nama_mk = tugas_nama_mk;
        this.tugas_namatugas = tugas_namatugas;
        this.tugas_deadline = tugas_deadline;
        this.tugas_keterangan = tugas_keterangan;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_tugas, parent, false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        holder.tvNamaMk.setText(String.valueOf(tugas_nama_mk.get(position)));
        holder.tvNamaTugas.setText(String.valueOf(tugas_namatugas.get(position)));
        holder.tvDeadline.setText(String.valueOf(tugas_deadline.get(position)));
        holder.tvKeterangan.setText(String.valueOf(tugas_keterangan.get(position)));
    }


    @Override
    public int getItemCount() {
        return tugas_id.size();
    }

    class ProfileViewHolder extends RecyclerView.ViewHolder {

        TextView tvNamaMk, tvNamaTugas, tvDeadline, tvKeterangan;
        LinearLayout mainLayout;

        ProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaMk = itemView.findViewById(R.id.textViewNamaMK);
            tvNamaTugas = itemView.findViewById(R.id.textViewNamaTugas);
            tvDeadline = itemView.findViewById(R.id.textViewDeadline);
            tvKeterangan = itemView.findViewById(R.id.textViewKeterangan);
        }
    }
}

