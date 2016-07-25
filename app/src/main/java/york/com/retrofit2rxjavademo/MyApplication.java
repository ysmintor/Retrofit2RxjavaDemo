package york.com.retrofit2rxjavademo;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import york.com.retrofit2rxjavademo.utils.LoggerInterceptor;
import york.com.retrofit2rxjavademo.utils.OkHttpUtils;

/**
 * @author YorkYu
 * @version V1.0
 * @Project: Retrofit2RxjavaDemo
 * @Package york.com.retrofit2rxjavademo
 * @Description:
 * @time 2016/7/25 17:08
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new LoggerInterceptor("TAG"))
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }
}
