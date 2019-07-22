package com.rizky.demank.Pemesanan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rizky.demank.Details.DetailBarang;
import com.rizky.demank.R;

import butterknife.BindView;
import butterknife.OnClick;

public class PemesananHome extends Fragment {

    @BindView(R.id.ivContent)
    ImageView ivContent;

    public static PemesananHome newInstance() {
        PemesananHome pemesananHome = new PemesananHome();
        return pemesananHome;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_pemesanan_home, container, false);
        return view;
    }

    @OnClick(R.id.ivContent)
    public void onViewClicked() {
        startActivity(new Intent(getContext(), DetailBarang.class));
    }
}
