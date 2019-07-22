package com.rizky.demank.Utils;

public class Utils {
    public static final String BASE_URL = "http://10.10.10.137/ecommerce/api/";
    public static final String BASE_IMAGES = "http://10.10.10.137/ecommerce/upload/category/";
    public static RequestInterface getApiServices(){
        return RetrofitClient.getClient(BASE_URL).create(RequestInterface.class);
    }
}
