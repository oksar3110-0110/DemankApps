package com.rizky.demank.Penjualan;

import com.google.gson.annotations.SerializedName;

public class DataPenjualan {
    /**
     * category_id : 9
     * category_name : Baju
     * category_image : 4784-2019-07-15.jpg
     */

    @SerializedName("category_id")
    private String categoryId;
    @SerializedName("category_name")
    private String categoryName;
    @SerializedName("category_image")
    private String categoryImage;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }
}
