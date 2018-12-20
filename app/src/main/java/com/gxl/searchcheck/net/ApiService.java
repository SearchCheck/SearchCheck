package com.gxl.searchcheck.net;

import com.gxl.searchcheck.utils.AppConstants;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * author : gxl
 * email : 1739037476@qq.com
 * create data : 2018/12/20
 * Describe  : 所有关于请求的api 都写到这个方法中
 */
public interface ApiService {

    //http://dict.youdao.com/suggest?q=%E4%BD%A0%E5%A5%BD&le=eng&num=1&doctype=json
    @Headers({"base_url:" + AppConstants.DICT})
    @POST("suggest")
    @FormUrlEncoded
    Observable<Test> test(@Field("q") String q, @Field("le") String le, @Field("num") int num, @Field("doctype") String json);

//    http://aider.meizu.com/app/weather/listWeather?cityIds= + 城市 id
    @Headers({"base_url:" + AppConstants.WEATHER})
    @POST("app/weather/listWeather")
    @FormUrlEncoded
    Observable<Test2> test2(@Field("cityIds") long id);

}
