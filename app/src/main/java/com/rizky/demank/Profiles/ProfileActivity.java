package com.rizky.demank.Profiles;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.balysv.materialripple.MaterialRippleLayout;
import com.rizky.demank.MainActivity;
import com.rizky.demank.R;
import com.rizky.demank.Utils.SessionManager;

import butterknife.BindView;
import butterknife.OnClick;

public class ProfileActivity extends Fragment {

    @BindView(R.id.txt_user_name)
    TextView txtUserName;
    @BindView(R.id.txt_user_email)
    TextView txtUserEmail;
    @BindView(R.id.txt_user_phone)
    TextView txtUserPhone;
    @BindView(R.id.txt_user_address)
    TextView txtUserAddress;
    @BindView(R.id.btn_edit_user)
    MaterialRippleLayout btnEditUser;
    @BindView(R.id.btnLogout)
    MaterialRippleLayout btnLogout;

    SessionManager mSes;

    public static ProfileActivity newINstance() {
        ProfileActivity profileActivity = new ProfileActivity();
        return profileActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile, container, false);
        mSes = new SessionManager(getContext());

//        txtUserName.setText(mSes.getSessionNama());
//        txtUserAddress.setText(mSes.getSessionAlamat());
//        txtUserEmail.setText(mSes.getSessionEmail());
//        txtUserPhone.setText(mSes.getSessionNohp());

        return view;
    }

    @OnClick(R.id.btnLogout)
    public void onViewClicked() {

                    mSes.saveSessionBoolean(SessionManager.SESSION_LOGIN, false);
                    startActivity(new Intent(getActivity().getApplication(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_HISTORY));
        Toast.makeText(getActivity().getApplication(), "Terimakasih!", Toast.LENGTH_SHORT).show();
                    getActivity().finish();

    }
}
