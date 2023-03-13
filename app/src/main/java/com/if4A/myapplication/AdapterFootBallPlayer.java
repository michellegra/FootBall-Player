package com.if4A.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterFootBallPlayer extends RecyclerView.Adapter<AdapterFootBallPlayer.ViewHolderPlayer> {
    private Context ctx;
    private ArrayList arrNama,arrNomor,arrKlub;

    public AdapterFootBallPlayer(Context ctx, ArrayList arrNama, ArrayList arrNomor, ArrayList arrKlub) {
        this.ctx = ctx;
        this.arrNama = arrNama;
        this.arrNomor = arrNomor;
        this.arrKlub = arrKlub;
    }

    @NonNull
    @Override
    public ViewHolderPlayer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.list_item_player, parent, false);

        return new ViewHolderPlayer(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPlayer holder, int position) {
        holder.tvNama.setText(arrNama.get(position).toString());
        holder.tvNomor.setText(arrNomor.get(position).toString());
        holder.tvKlub.setText(arrKlub.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return arrNama.size();
    }

    public class ViewHolderPlayer extends RecyclerView.ViewHolder{
        private TextView tvNama, tvNomor, tvKlub;

        public ViewHolderPlayer(@NonNull View itemView) {
            super(itemView);
            tvNama =itemView.findViewById(R.id.tv_nama);
            tvNomor =itemView.findViewById(R.id.tv_no);
            tvKlub =itemView.findViewById(R.id.tv_klub);
        }
    }
}
