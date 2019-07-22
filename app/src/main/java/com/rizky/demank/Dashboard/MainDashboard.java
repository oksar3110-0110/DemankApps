package com.rizky.demank.Dashboard;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rizky.demank.Pemesanan.PemesananHome;
import com.rizky.demank.Penjualan.PenjualanHome;
import com.rizky.demank.Profiles.ProfileActivity;
import com.rizky.demank.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainDashboard extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.frameparent2)
    FrameLayout frameparent2;
    @BindView(R.id.botNav2)
    BottomNavigationView botNav2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);
        ButterKnife.bind(this);
        botNav2.setOnNavigationItemSelectedListener(this);
        Fragment fragments = PenjualanHome.newInstance();
        loadFragment(fragments);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.penjualan:
                fragment = PenjualanHome.newInstance();
                break;
            case R.id.pemesanan:
                fragment = PemesananHome.newInstance();
                break;
            case R.id.proFile:
                fragment = ProfileActivity.newINstance();
                break;
        }

        return loadFragment(fragment);
    }

    public boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameparent2,fragment)
                    .commit();
            return true;
        }

        return false;
    }


}
