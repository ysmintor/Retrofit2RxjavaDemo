package york.com.retrofit2rxjavademo;

import android.app.Application;

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
       /* OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addNetworkInterceptor(
                        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        OkHttpUtils.initClient(okHttpClient);*/
    }
}
