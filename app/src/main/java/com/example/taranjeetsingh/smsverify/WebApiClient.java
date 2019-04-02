package com.example.taranjeetsingh.smsverify;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Taranjeet Singh on 17-Sep-18.
 */
public class WebApiClient {
    public static Retrofit getApiClinet() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS);
        builder = new Retrofit.Builder()
                .baseUrl("http://uat.shalimarpaints.in:9005/")
                .addConverterFactory(GsonConverterFactory.create());
        return builder.client(httpClient.build()).build();
    }


    private static Retrofit.Builder builder;
}
