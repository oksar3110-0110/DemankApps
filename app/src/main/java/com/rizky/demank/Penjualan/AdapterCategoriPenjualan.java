package com.rizky.demank.Penjualan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rizky.demank.R;
import com.rizky.demank.Utils.SessionManager;
import com.rizky.demank.Utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterCategoriPenjualan extends RecyclerView.Adapter<AdapterCategoriPenjualan.ViewHolder> {

    ArrayList<DataPenjualan> dataPenjualans;
    Context mContext;
    SessionManager mSes;

    public AdapterCategoriPenjualan(ArrayList<DataPenjualan> dataPenjualans){
        this.dataPenjualans = dataPenjualans;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowcategory, parent, false);
        mContext = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.with(mContext)
                .load(Utils.BASE_IMAGES+dataPenjualans.get(position).getCategoryImage())
                .into(holder.images);
        holder.txnama.setText(dataPenjualans.get(position).getCategoryName());
    }

    @Override
    public int getItemCount() {
        return dataPenjualans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txnama;
        private ImageView images;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txnama = itemView.findViewById(R.id.namaBarang);
            images = itemView.findViewById(R.id.ivContent);
        }
    }
}
