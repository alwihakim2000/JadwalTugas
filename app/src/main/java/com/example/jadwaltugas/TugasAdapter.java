package com.example.jadwaltugas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TugasAdapter extends RecyclerView.Adapter<TugasAdapter.TugasViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList tugas_id, tugas_nama_mk, tugas_namatugas, tugas_deadline, tugas_keterangan;

    public TugasAdapter(Activity activity, Context context, ArrayList tugas_id, ArrayList tugas_nama_mk, ArrayList tugas_namatugas, ArrayList tugas_deadline, ArrayList tugas_keterangan) {
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
    public TugasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_tugas, parent, false);
        return new TugasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TugasViewHolder holder, int position) {
        holder.textViewNamaMK.setText(String.valueOf(tugas_nama_mk.get(position)));
        holder.textViewNamaTugas.setText(String.valueOf(tugas_namatugas.get(position)));
        holder.textViewDeadline.setText(String.valueOf(tugas_deadline.get(position)));
        holder.textViewKeterangan.setText(String.valueOf(tugas_keterangan.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TampilanTugas.class);
                intent.putExtra("id", String.valueOf(tugas_id.get(position)));
                intent.putExtra("nama_tugas", String.valueOf(tugas_namatugas.get(position)));
                intent.putExtra("nama_mk", String.valueOf(tugas_nama_mk.get(position)));
                intent.putExtra("deadline", String.valueOf(tugas_deadline.get(position)));
                intent.putExtra("keterangan", String.valueOf(tugas_keterangan.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }


    @Override
    public int getItemCount() {
        return tugas_id.size();
    }

    class TugasViewHolder extends RecyclerView.ViewHolder {

        TextView textViewNamaMK, textViewNamaTugas, textViewDeadline,
                textViewKeterangan;
        LinearLayout mainLayout;

        TugasViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNamaMK = itemView.findViewById(R.id.textViewNamaMK);
            textViewNamaTugas = itemView.findViewById(R.id.textViewNamaTugas);
            textViewDeadline = itemView.findViewById(R.id.textViewDeadline);
            textViewKeterangan = itemView.findViewById(R.id.textViewKeterangan);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}

