package com.example.chenshuai20180514.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 不将就 on 2018/5/14.
 */

public class Retrofits {
    private static OkHttpClient httpClient;
    private static RetrofiterAPI retrofiterAPI;

    static {
        getHttpClient();
    }

    public static OkHttpClient getHttpClient() {
        if (httpClient == null) {
            synchronized (RetrofiterAPI.class) {
                if (httpClient == null) {
                    httpClient = new OkHttpClient();
                }
            }
        }
        return httpClient;
    }

    public static RetrofiterAPI getRetrofiterAPI() {
        if (retrofiterAPI == null) {
            synchronized (OkHttpClient.class) {
                if (retrofiterAPI == null) {
                    retrofiterAPI = onCreate(RetrofiterAPI.class, Api.HOST);
                }
            }
        }
        return retrofiterAPI;
    }

    public static <T> T onCreate(Class<T> tClass, String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build();
        return retrofit.create(tClass);
    }
}
