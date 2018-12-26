package com.gxl.searchcheck.net;

import com.gxl.searchcheck.app.URLs;
import com.gxl.searchcheck.utils.AppConstants;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;

/**
 * @author Tomze
 * @time 2018年12月21日 1:07
 * @desc 根据请求头信息修改baseUrl的拦截器
 */
public class ChangeUrlInterceptor implements Interceptor {

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl oldHttpUrl = request.url();
        Request.Builder builder = request.newBuilder();
        List<String> headerValues = request.headers("base_url");
        if (headerValues != null && headerValues.size() > 0) {
            //如果有这个header，先将配置的header删除，因此header仅用作app和okhttp之间使用
            builder.removeHeader("base_url");
            String headerValue = headerValues.get(0);
            HttpUrl newBaseUrl = null;
            switch (headerValue) {
                case AppConstants.DICT:
                    newBaseUrl = HttpUrl.parse(URLs.DICT_URL);
                    break;
                case AppConstants.TRANSLATE:
                    newBaseUrl = HttpUrl.parse(URLs.TRANSLATE_URL);
                    break;
                case AppConstants.WEATHER:
                    newBaseUrl = HttpUrl.parse(URLs.WEATHER_URL);
                    break;
                case AppConstants.EXPRESS:
                    newBaseUrl = HttpUrl.parse(URLs.EXPRESS_URL);
                    break;
                case AppConstants.MOVIE:
                    newBaseUrl = HttpUrl.parse(URLs.MOVIE_URL);
                    break;
            }
            //重建新的HttpUrl，修改需要修改的url部分
            HttpUrl newFullUrl = oldHttpUrl
                    .newBuilder()
                    .scheme(newBaseUrl.scheme())
                    .host(newBaseUrl.host())
                    .port(newBaseUrl.port())
                    .build();
            //重建这个request，通过builder.url(newFullUrl).build()；
            // 然后返回一个response至此结束修改
            return chain.proceed(builder.url(newFullUrl).build());
        }
        return chain.proceed(request);
    }
}