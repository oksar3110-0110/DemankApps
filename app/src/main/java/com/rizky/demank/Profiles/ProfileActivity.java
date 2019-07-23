package com.rizky.demank.Profiles;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rizky.demank.R;
import com.rizky.demank.Utils.SessionManager;

import butterknife.BindView;
import butterknife.OnClick;

public class ProfileActivity extends Fragment {


    SessionManager mSes;
    @BindView(R.id.txt_user_name)
    TextView txtUserName;
    @BindView(R.id.txt_user_email)
    TextView txtUserEmail;
    @BindView(R.id.txt_user_phone)
    TextView txtUserPhone;
    @BindView(R.id.txt_user_address)
    TextView txtUserAddress;
    @BindView(R.id.btEdit)
    TextView btEdit;
    @BindView(R.id.logoutBt)
    TextView logoutBt;

    public static ProfileActivity newINstance() {
        ProfileActivity profileActivity = new ProfileActivity();
        return profileActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile, container, false);
        mSes = new SessionManager(getContext());

        txtUserName.setText(mSes.getSessionNama());
        txtUserAddress.setText(mSes.getSessionAlamat());
        txtUserEmail.setText(mSes.getSessionEmail());
        txtUserPhone.setText(mSes.getSessionNohp());

        return view;
    }


    @OnClick({R.id.btEdit, R.id.logoutBt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btEdit:
                break;
            case R.id.logoutBt:
                Log.d("messages :", "logout");
                break;
        }
    }
}
