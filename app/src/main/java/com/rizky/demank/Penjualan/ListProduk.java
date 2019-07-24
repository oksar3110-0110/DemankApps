package com.rizky.demank.Penjualan;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rizky.demank.Penjualan.ResponItemPenjualan.AdapterPenjualanItem;
import com.rizky.demank.Penjualan.ResponItemPenjualan.DataPenjualan;
import com.rizky.demank.Penjualan.ResponItemPenjualan.ResponseItemPenjualan;
import com.rizky.demank.R;
import com.rizky.demank.Utils.RequestInterface;
import com.rizky.demank.Utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListProduk extends AppCompatActivity {

    @BindView(R.id.backButton)
    ImageView backButton;
    @BindView(R.id.product)
    TextView product;
    @BindView(R.id.topNav)
    LinearLayout topNav;
    @BindView(R.id.recyclerList)
    RecyclerView recyclerList;
    @BindView(R.id.container)
    ScrollView container;

    RequestInterface mReq;
    ArrayList<DataPenjualan> dataPenjualans;
    AdapterPenjualanItem adapterPenjualanItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_produk);
        mReq = Utils.getApiServices();
        ButterKnife.bind(this);
        recyclerList.setHasFixedSize(true);
        recyclerList.setLayoutManager(new GridLayoutManager(this, 2));
        loaddata();
    }

    private void loaddata() {
        final String id = getIntent().getStringExtra("id");
        mReq.getItem(id).enqueue(new Callback<ResponseItemPenjualan>() {
            @Override
            public void onResponse(Call<ResponseItemPenjualan> call, Response<ResponseItemPenjualan> response) {
                if(response.isSuccessful()){
                    ResponseItemPenjualan responseItemPenjualan = response.body();
                    dataPenjualans = new ArrayList<>(Arrays.asList(responseItemPenjualan.getData()));
                    adapterPenjualanItem = new AdapterPenjualanItem(dataPenjualans);
                    recyclerList.setAdapter(adapterPenjualanItem);
                }
            }

            @Override
            public void onFailure(Call<ResponseItemPenjualan> call, Throwable t) {

            }
        });

    }

    @OnClick(R.id.backButton)
    public void onViewClicked() {
    }
}
