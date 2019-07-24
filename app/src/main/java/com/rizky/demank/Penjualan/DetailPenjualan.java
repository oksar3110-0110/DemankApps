package com.rizky.demank.Penjualan;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rizky.demank.Penjualan.ResponItemPenjualan.ResponseItemPenjualan;
import com.rizky.demank.Penjualan.ResponseDetail.ResponseDetail;
import com.rizky.demank.R;
import com.rizky.demank.Utils.RequestInterface;
import com.rizky.demank.Utils.Utils;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPenjualan extends AppCompatActivity {

    @BindView(R.id.backButton)
    ImageView backButton;
    @BindView(R.id.product)
    TextView product;
    @BindView(R.id.topNav)
    LinearLayout topNav;
    @BindView(R.id.ivSell)
    ImageView ivSell;
    @BindView(R.id.namaBarang)
    TextView namaBarang;
    @BindView(R.id.hargaContent)
    TextView hargaContent;
    @BindView(R.id.Stok)
    TextView Stok;
    @BindView(R.id.details)
    TextView details;
    @BindView(R.id.buttonBuy)
    Button buttonBuy;
    @BindView(R.id.container)
    ScrollView container;
    RequestInterface mReq;
    Context context;
    String mes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penjualan);
        mReq = Utils.getApiServices();
        ButterKnife.bind(this);

        context = this;
        LoadData();
    }

    private void LoadData() {
    String id = getIntent().getStringExtra("id");
    mReq.getDetailItem(id).enqueue(new Callback<ResponseDetail>() {
        @Override
        public void onResponse(Call<ResponseDetail> call, Response<ResponseDetail> response) {
            ResponseDetail responseDetail = response.body();
            if(responseDetail.getStatus()==200){
                for(int i=0; i>responseDetail.getData().size(); i++){
                    product.setText(responseDetail.getData().get(i).getProductName());
                    mes = responseDetail.getData().get(i).getProductName();
                    Picasso.with(context)
                            .load(Utils.BASE_IMAGES+responseDetail.getData().get(i).getProductImage())
                            .into(ivSell);
                    hargaContent.setText(responseDetail.getData().get(i).getProductPrice());
                    namaBarang.setText(responseDetail.getData().get(i).getProductName());
                    Stok.setText(responseDetail.getData().get(i).getProductQuantity());
                    details.setText(responseDetail.getData().get(i).getProductDescription());
                }
            }
        }

        @Override
        public void onFailure(Call<ResponseDetail> call, Throwable t) {

        }
    });
    }

    @OnClick({R.id.backButton, R.id.buttonBuy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.backButton:
                finish();
                break;
            case R.id.buttonBuy:
                Toast.makeText(context,mes , Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
