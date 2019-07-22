package com.rizky.demank.Login;

import com.google.gson.annotations.SerializedName;

public class ResponseLogin {


    /**
     * status : 200
     * data : {"id_user":"1","nama":"Bahrainsyah","email":"versaikun@gmail.com","username":"oksa","password":"123456","alamat":"JL JATIBARANG RAYA NO 5 INDRAMAYU 45155","nohp":"083122814441"}
     * message : sukses!
     */

    @SerializedName("status")
    private int status;
    @SerializedName("data")
    private DataChartBean data;
    @SerializedName("message")
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataChartBean getData() {
        return data;
    }

    public void setData(DataChartBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
