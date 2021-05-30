package lib.net;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import lib.util.FormatUtil;
import lib.util.JLog;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jcs on 2021/5/26.
 * Describe
 */
public class RetrofitHelp {
    public static boolean isDebug = false;

    private static RetrofitHelp retrofitHelp;
    public static RetrofitHelp get(){
        if(retrofitHelp==null){
            retrofitHelp=new RetrofitHelp();
        }
        return retrofitHelp;
    }

    public <T> T request(String baseUrl, final Class<T> service){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(getOKHttpClient())
                .build()
                .create(service);
    }

    public Gson getGson(){
        return  new GsonBuilder()
                .setDateFormat(FormatUtil.dateTime())
                .setLenient()
                .create();
    }

    public OkHttpClient getOKHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(new RequestInterceptor())
                .addInterceptor(new LogInterceptor())
                .build();
    }


    /**
     * 日志拦截器
     */
    private static class LogInterceptor implements Interceptor {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            long t1 = System.currentTimeMillis();
            okhttp3.Response response = chain.proceed(chain.request());
            long t2 = System.currentTimeMillis();
            okhttp3.MediaType mediaType = response.body().contentType();
            String content = response.body().string();
            if(isDebug){
                JLog.i("RetrofitHelp","response.url:" + response.request().url());
                JLog.i("RetrofitHelp","response.headers:" + response.headers());
                JLog.i("RetrofitHelp","response.time:" + (t2 - t1));
                JLog.i("RetrofitHelp","response.body:" + content);
            }
            return response.newBuilder()
                    .body(okhttp3.ResponseBody.create(mediaType, content))
                    .build();
        }
    }

    /**
     * 请求拦截器，修改请求header
     */
    private static class RequestInterceptor implements Interceptor{
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request()
                    .newBuilder()
//                    .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
//                    .addHeader("Accept-Encoding", "*")
//                    .addHeader("Connection", "keep-alive")
//                    .addHeader("Accept", "*/*")
//                    .addHeader("Access-Control-Allow-Origin", "*")
//                    .addHeader("Access-Control-Allow-Headers", "X-Requested-With")
//                    .addHeader("Vary", "Accept-Encoding")
//                    .addHeader("Cookie", "add cookies here")
                    .build();
            if(isDebug){
                JLog.i("RetrofitHelp","request:" + request.toString());
                JLog.i("RetrofitHelp","request.headers:" + request.headers().toString());
            }
            return chain.proceed(request);
        }
    }
}
