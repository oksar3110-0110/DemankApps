package com.rizky.demank.Utils;

public class Utils {
    public static final String BASE_URL = "http://demankanime.dermayu.id/api/";
    public static final String BASE_IMAGES = "http://demankanime.dermayu.id/upload/category/";
    public static RequestInterface getApiServices(){
        return RetrofitClient.getClient(BASE_URL).create(RequestInterface.class);
    }
}
