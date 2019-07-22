package com.rizky.demank.Utils;

import com.rizky.demank.Login.ResponseLogin;
import com.rizky.demank.Penjualan.ResponsePenjualan;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RequestInterface {

    @FormUrlEncoded
    @POST("api.php?login")
    Call<ResponseLogin> getLogin(
            @Field("email") String email,
            @Field("password") String password
    );


    @GET("api.php?penjualan")
    Call<ResponsePenjualan> getCategoryPenjualan();
}
