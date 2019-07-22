package com.rizky.demank;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rizky.demank.Dashboard.MainDashboard;
import com.rizky.demank.Login.ResponseLogin;
import com.rizky.demank.Register.RegisterActivity;
import com.rizky.demank.Utils.RequestInterface;
import com.rizky.demank.Utils.SessionManager;
import com.rizky.demank.Utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.forgotPass)
    TextView forgotPass;
    @BindView(R.id.loginBT)
    Button loginBT;
    @BindView(R.id.register)
    TextView register;

    ProgressDialog loading;
    Context mContext;
    RequestInterface mReq;
    SessionManager mSession;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;
        mReq = Utils.getApiServices();
        mSession = new SessionManager(mContext);
    }


    @OnClick({R.id.forgotPass, R.id.loginBT, R.id.register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forgotPass:
                break;
            case R.id.loginBT:
                if(TextUtils.isEmpty(etEmail.getText())){
                    etEmail.setError("Email tidak boleh kosong!");
                } else if (TextUtils.isEmpty(etPassword.getText())){
                    etPassword.setError("Password tidak boleh kosong!");

                } else {
                    loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                    getLogin(etEmail.getText().toString(),etPassword.getText().toString());
                }
                break;
            case R.id.register:
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                break;
        }
    }

    private void getLogin(String toString, String toString1) {
        mReq.getLogin(toString,toString1).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                ResponseLogin responseLogin = response.body();
                if(responseLogin.getStatus()==200){
                    loading.dismiss();
                    mSession.saveSessionBoolean(SessionManager.SESSION_LOGIN, true);
                    mSession.saveSessionStr(SessionManager.SESSION_ALAMAT, responseLogin.getData().getAlamat());
                    mSession.saveSessionStr(SessionManager.SESSION_NOHP, responseLogin.getData().getNohp());
                    mSession.saveSessionStr(SessionManager.SESSION_EMAIL, responseLogin.getData().getEmail());
                    mSession.saveSessionStr(SessionManager.SESSION_NAMA, responseLogin.getData().getNama());
                    mSession.saveSessionStr(SessionManager.SESSION_USERNAME, responseLogin.getData().getUsername());
                    mSession.saveSessionStr(SessionManager.SESSION_IDUSER, responseLogin.getData().getIdUser());

                    Toast.makeText(MainActivity.this, responseLogin.getMessage(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, MainDashboard.class));
                    finish();
                } else {

                            loading.dismiss();
                            Toast.makeText(MainActivity.this, "Username Password Salah!", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {

            }
        });
    }
}
