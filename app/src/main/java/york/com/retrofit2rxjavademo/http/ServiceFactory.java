package york.com.retrofit2rxjavademo.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import york.com.retrofit2rxjavademo.utils.OkHttpUtils;

/**
 * Created by York on 2016/7/23.
 */
public class ServiceFactory {
//    public static final String OLD_BASE_URL = "https://liangfeizc.com/gw/oauthentry/";
//    public static final String NEW_BASE_URL = "https://liangfei.me/api/oauthentry/";
    public static final String BASE_URL = "https://api.douban.com/v2/movie/";
    private static final int DEFAULT_TIMEOUT = 10;
    private static Retrofit sRetrefit;
    private static OkHttpClient sClient;




    static {
        sClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                .addInterceptor(new HeaderInterceptor())
//                .addInterceptor(new TokenInterceptor())
                .addNetworkInterceptor(
                        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .retryOnConnectionFailure(true)
                .build();
        OkHttpUtils.initClient(sClient);

         sRetrefit = new Retrofit.Builder()
                .client(sClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static <T> T createService(Class<T> serviceClazz) {

        return sRetrefit.create(serviceClazz);
    }

    /**
     * 创建
     *
     * @param baseUrl
     * @param serviceClazz
     * @param <T>
     * @return
     */
    public static <T> T createService(String baseUrl, Class<T> serviceClazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(sClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(serviceClazz);
    }

    /**
     * 创建
     *
     * @param serviceClazz
     * @param okHttpClient 外部传入自定义okhttp，如上传文件时加长timeout时间
     * @param <T>
     * @return
     */
    public static <T> T createService(Class<T> serviceClazz, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(serviceClazz);
    }

    /**
     * 创建
     *
     * @param baseUrl
     * @param serviceClazz
     * @param okHttpClient
     * @param <T>
     * @return
     */
    public static <T> T createService(String baseUrl, Class<T> serviceClazz, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(serviceClazz);
    }

    /**
     * 向外部提供api请求
     * @return
     */
    public static MovieService movieApi() {
        return ServiceFactory.createService(MovieService.class);
    }
}
