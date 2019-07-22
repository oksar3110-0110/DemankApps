package com.rizky.demank.Penjualan;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponsePenjualan {

    /**
     * status : 200
     * data : [{"category_id":"9","category_name":"Baju","category_image":"4784-2019-07-15.jpg"},{"category_id":"10","category_name":"Jaket Hoody","category_image":"4784-2019-07-15.jpg"}]
     * message : sukses!
     */

    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataPenjualan[] data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataPenjualan[] getData() {
        return data;
    }

    public void setData(DataPenjualan[] data) {
        this.data = data;
    }
}
