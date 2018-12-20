package com.gxl.searchcheck.net;

import com.gxl.searchcheck.app.URLs;
import com.gxl.searchcheck.greendao.DaoManager;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author : gxl
 * email : 1739037476@qq.com
 * create data : 2018/12/20
 * Describe  :
 */
public class RetrofitManager {
    private static volatile RetrofitManager mInstance;
    private final Retrofit mRetrofit;

    private RetrofitManager() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new ChangeUrlInterceptor())
                .writeTimeout(10000, TimeUnit.MILLISECONDS)
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(URLs.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * 获取DaoManager的实例
     */
    public static RetrofitManager getInstance() {
        if (mInstance == null) {
            synchronized (DaoManager.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 获取Service接口实例
     */
    public <T> T create(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }
}
