package com.my.retrofitdemo.networkapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.my.retrofitdemo.apiinterface.MultipleFileUploadingServiceWithPart;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class RetrofitInstance {
    private static final RetrofitInstance ourInstance = new RetrofitInstance();

    public static RetrofitInstance getInstance() {
        return ourInstance;
    }

    public Retrofit with() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory())
                .create();

        return new Retrofit.Builder()
                .baseUrl("BASE_URL")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();
    }

    public Retrofit withMultiImage() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient();
        OkHttpClient clientWith30sTimeout = okHttpClient.newBuilder()
                .readTimeout(30000, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();
        return new Retrofit.Builder()
                .baseUrl("BASE_URL")
                .client(clientWith30sTimeout)
                .addConverterFactory(new MultiPartConverter())
                .build();
    }
    public Retrofit withSingleImage() {
        OkHttpClient okHttpClient = new OkHttpClient();
        OkHttpClient clientWith30sTimeout = okHttpClient.newBuilder()
                .readTimeout(30000, TimeUnit.SECONDS)
                .build();
        return new Retrofit.Builder()
                .baseUrl("BASE_URL")
                .client(clientWith30sTimeout)
                .addConverterFactory(new MultiPartConverter())
                .build();
    }
}