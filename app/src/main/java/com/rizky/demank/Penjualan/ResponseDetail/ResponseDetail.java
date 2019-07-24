package com.rizky.demank.Penjualan.ResponseDetail;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseDetail {

    /**
     * status : 200
     * data : [{"product_id":"55","product_name":"baju one piace","product_price":"75000","product_status":"Available","product_image":"1563859743_.jpg","product_description":"<p>baju bagus lebaran<\/p>\r\n","product_quantity":"50","category_id":"9"}]
     * messages : OK !
     */

    @SerializedName("status")
    private int status;
    @SerializedName("messages")
    private String messages;
    @SerializedName("data")
    private List<Dataitempenjualan> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public List<Dataitempenjualan> getData() {
        return data;
    }

    public void setData(List<Dataitempenjualan> data) {
        this.data = data;
    }
}
