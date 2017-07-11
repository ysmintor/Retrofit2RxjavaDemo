package york.com.retrofit2rxjavademo.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import york.com.retrofit2rxjavademo.MyApplication;
import york.com.retrofit2rxjavademo.di.scope.AppScope;
import york.com.retrofit2rxjavademo.di.scope.AppScope;
import york.com.retrofit2rxjavademo.gsonconverter.CustomGsonConverterFactory;
import york.com.retrofit2rxjavademo.http.ServiceFactory;
import york.com.retrofit2rxjavademo.http.exception.ServerException;

/**
 * @author: YorkYu
 * @version: V2.0.0
 * @project: Retrofit2RxjavaDemo
 * @package: york.com.retrofit2rxjavademo.di.module
 * @description: description
 * @date: 2017/7/7
 * @time: 17:31
 */
@Module
public class NetworkModule {
//    private String mBaseUrl = "http://rap.taobao.org/mockjsdata/15987/";
    private String mBaseUrl;
    private int DEFAULT_TIMEOUT = 10;

    // Constructor needs one parameter to instantiate.
    public NetworkModule(String baseUrl, int default_timeout) {
        this.mBaseUrl = baseUrl;
        this.DEFAULT_TIMEOUT = default_timeout;
    }

    // Dagger will only look for methods annotated with @Provides
    @Provides
    @AppScope
    // Application reference must come from AppModule.class
    SharedPreferences providesSharedPreferences(MyApplication application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @AppScope
    Cache provideOkHttpCache(MyApplication application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @AppScope
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY);
        return gsonBuilder.create();
    }

    @Provides
    @AppScope
    @Named("cached")
    OkHttpClient provideOkHttpClient(Cache cache) {
        OkHttpClient client =
                new OkHttpClient.Builder()
                        .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .addNetworkInterceptor(
                                new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                        .retryOnConnectionFailure(true)
                        .cache(cache)
                        .build();
        return client;
    }

    @Provides
    @AppScope
    @Named("noncached")
    OkHttpClient provideNonCachedOkHttpClient() {
        OkHttpClient client =
                new OkHttpClient.Builder()
                        .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .addNetworkInterceptor(
                                new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                        .retryOnConnectionFailure(true)
                        .build();
        return client;
    }

    @Provides
    @AppScope
    Retrofit provideRetrofit(Gson gson, @Named("cached") OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(mBaseUrl)
                .build();
    }


    /**
     *  使用自定义Converter处理message在错误时返回在data字段
     * @param gson
     * @param okHttpClient
     * @return
     */
    @Provides
    @AppScope
    @Named("custom_converter")
    Retrofit provideCustomConverterRetrofit(Gson gson, @Named("cached") OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(CustomGsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(mBaseUrl)
                .build();
    }
}
