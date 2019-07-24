package com.rizky.demank.Penjualan.ResponItemPenjualan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rizky.demank.Penjualan.AdapterCategoriPenjualan;
import com.rizky.demank.Penjualan.DetailPenjualan;
import com.rizky.demank.R;
import com.rizky.demank.Utils.SessionManager;
import com.rizky.demank.Utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterPenjualanItem extends RecyclerView.Adapter<AdapterPenjualanItem.ViewHolder>{


    ArrayList<DataPenjualan> dataPenjualans;
    Context mContext;
    SessionManager mSes;

    public AdapterPenjualanItem(ArrayList<DataPenjualan> dataPenjualans){
        this.dataPenjualans = dataPenjualans;
    }

    @NonNull
    @Override
    public AdapterPenjualanItem.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_sell, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPenjualanItem.ViewHolder holder,final int position) {
        Picasso.with(mContext)
                .load(Utils.BASE_IMAGES+dataPenjualans.get(position).getProductImage())
                .resize(160,75)
                .into(holder.images);
        holder.images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailPenjualan.class);
                intent.putExtra("id", String.valueOf(dataPenjualans.get(position).getProductId()));
                mContext.startActivity(intent);
            }
        });
        holder.txnama.setText(dataPenjualans.get(position).getProductName());
        holder.txstok.setText(dataPenjualans.get(position).getProductQuantity());
        holder.txharga.setText(dataPenjualans.get(position).getProductPrice());
    }

    @Override
    public int getItemCount() {
        return dataPenjualans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txnama, txharga, txstok;
        private ImageView images;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            txharga = itemView.findViewById(R.id.harga);
            txnama = itemView.findViewById(R.id.namaBarang);
            txstok = itemView.findViewById(R.id.stok);
            images = itemView.findViewById(R.id.ivContent);
        }
    }
}
