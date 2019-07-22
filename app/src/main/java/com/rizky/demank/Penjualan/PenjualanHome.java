package com.rizky.demank.Penjualan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rizky.demank.R;
import com.rizky.demank.Utils.RequestInterface;
import com.rizky.demank.Utils.SessionManager;
import com.rizky.demank.Utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PenjualanHome extends Fragment {


    AdapterCategoriPenjualan adapterCategoriPenjualan;
    RequestInterface mReq;
    SessionManager mSes;
    ArrayList<DataPenjualan> dataPenjualans;
    @BindView(R.id.titleCate)
    TextView titleCate;
    @BindView(R.id.framePenjualan)
    RecyclerView framePenjualan;

    Unbinder unbinder;
    public static PenjualanHome newInstance() {
        PenjualanHome penjualanHome = new PenjualanHome();
        return penjualanHome;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_penjualan_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        mReq = Utils.getApiServices();
        framePenjualan.setHasFixedSize(true);
        framePenjualan.setLayoutManager(new GridLayoutManager(getContext(), 2));


        getData();
        return view;
    }

    private void getData() {
        mReq.getCategoryPenjualan().enqueue(new Callback<ResponsePenjualan>() {
            @Override
            public void onResponse(Call<ResponsePenjualan> call, Response<ResponsePenjualan> response) {
                ResponsePenjualan responsePenjualan = response.body();
                dataPenjualans = new ArrayList<>(Arrays.asList(responsePenjualan.getData()));
                adapterCategoriPenjualan = new AdapterCategoriPenjualan(dataPenjualans);
                framePenjualan.setAdapter(adapterCategoriPenjualan);
            }

            @Override
            public void onFailure(Call<ResponsePenjualan> call, Throwable t) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
