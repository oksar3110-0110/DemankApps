package com.rizky.demank.Penjualan.ResponseDetail;

import com.google.gson.annotations.SerializedName;

public class Dataitempenjualan {
    /**
     * product_id : 55
     * product_name : baju one piace
     * product_price : 75000
     * product_status : Available
     * product_image : 1563859743_.jpg
     * product_description : <p>baju bagus lebaran</p>
     * product_quantity : 50
     * category_id : 9
     */

    @SerializedName("product_id")
    private String productId;
    @SerializedName("product_name")
    private String productName;
    @SerializedName("product_price")
    private String productPrice;
    @SerializedName("product_status")
    private String productStatus;
    @SerializedName("product_image")
    private String productImage;
    @SerializedName("product_description")
    private String productDescription;
    @SerializedName("product_quantity")
    private String productQuantity;
    @SerializedName("category_id")
    private String categoryId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
