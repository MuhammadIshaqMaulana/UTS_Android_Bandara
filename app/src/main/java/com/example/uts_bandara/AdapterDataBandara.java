package com.example.uts_bandara;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDataBandara extends RecyclerView.Adapter<AdapterDataBandara.ViewHolderPlayer>{

    private Context ctx;
    private ArrayList arrID, arrNama, arrKota, arrAlamat;

    public AdapterDataBandara(Context ctx, ArrayList arrID, ArrayList arrNama, ArrayList arrKota, ArrayList arrAlamat) {
        this.ctx = ctx;
        this.arrNama = arrNama;
        this.arrKota = arrKota;
        this.arrAlamat = arrAlamat;
        this.arrID = arrID;
    }

    @NonNull
    @Override
    public ViewHolderPlayer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.list_item_bandara, parent, false);
        return new ViewHolderPlayer(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPlayer holder, int position) {
        holder.tvNama.setText(arrNama.get(position).toString());
        holder.tvKota.setText(arrKota.get(position).toString());
        holder.tvAlamat.setText(arrAlamat.get(position).toString());
        holder.tvID.setText(arrID.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return arrNama.size();
    }

    public class ViewHolderPlayer extends RecyclerView.ViewHolder{
        private TextView tvID, tvNama, tvKota, tvAlamat;
        public ViewHolderPlayer(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvKota = itemView.findViewById(R.id.tv_kota);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvID = itemView.findViewById(R.id.tv_id);

        }
    }
}
