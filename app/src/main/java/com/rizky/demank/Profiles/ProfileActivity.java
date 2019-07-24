package com.rizky.demank.Profiles;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rizky.demank.MainActivity;
import com.rizky.demank.R;
import com.rizky.demank.Utils.SessionManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

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

    Unbinder unbinder;
    public static ProfileActivity newINstance() {
        ProfileActivity profileActivity = new ProfileActivity();
        return profileActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile, container, false);
        unbinder = ButterKnife.bind(this, view);
        mSes = new SessionManager(getActivity());

        txtUserEmail.setText(mSes.getSessionEmail());
        txtUserAddress.setText(mSes.getSessionAlamat());
        txtUserPhone.setText(mSes.getSessionNohp());
        txtUserName.setText(mSes.getSessionUsername());
        return view;
    }



    @OnClick({R.id.btEdit, R.id.logoutBt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btEdit:
                break;
            case R.id.logoutBt:

                mSes.saveSessionBoolean(SessionManager.SESSION_LOGIN, false);
                startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
