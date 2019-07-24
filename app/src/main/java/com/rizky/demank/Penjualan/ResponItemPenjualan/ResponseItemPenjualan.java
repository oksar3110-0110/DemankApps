package com.rizky.demank.Penjualan.ResponItemPenjualan;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseItemPenjualan {

    /**
     * status : 200
     * data : [{"product_id":"55","product_name":"baju one piace","product_price":"75000","product_status":"Available","product_image":"1563859743_.jpg","product_description":"<p>baju bagus lebaran<\/p>\r\n","product_quantity":"50","category_id":"9"},{"product_id":"56","product_name":"Baju luffy","product_price":"800000","product_status":"Available","product_image":"1563859920_Baju lufy 4.jpg","product_description":"<table cellspacing=\"0\" style=\"height:83px; width:311px\">\r\n\t<tbody>\r\n\t\t<tr>\r\n\t\t\t<th style=\"background-color:#fafafa\">Ukuran&nbsp;<\/th>\r\n\t\t\t<td style=\"background-color:#fafafa; border-color:#f2f2f2; vertical-align:top\">M,L<\/td>\r\n\t\t<\/tr>\r\n\t\t<tr>\r\n\t\t\t<th>Berat (kg)<\/th>\r\n\t\t\t<td style=\"border-color:#f2f2f2; vertical-align:top\">0.6<\/td>\r\n\t\t<\/tr>\r\n\t\t<tr>\r\n\t\t\t<th style=\"background-color:#fafafa\">Warna<\/th>\r\n\t\t\t<td style=\"background-color:#fafafa; border-color:#f2f2f2; vertical-align:top\">HITAM<\/td>\r\n\t\t<\/tr>\r\n\t<\/tbody>\r\n<\/table>\r\n\r\n<p>* Kualitas bahan yang bagus dijamin gak nyesel, buruan order sebelum kehabisan.<\/p>\r\n","product_quantity":"10","category_id":"9"}]
     * messages : OK !
     */

    @SerializedName("status")
    private int status;
    @SerializedName("messages")
    private String messages;
    @SerializedName("data")
    private DataPenjualan[] data;

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

    public DataPenjualan[] getData() {
        return data;
    }

    public void setData(DataPenjualan[] data) {
        this.data = data;
    }
}
