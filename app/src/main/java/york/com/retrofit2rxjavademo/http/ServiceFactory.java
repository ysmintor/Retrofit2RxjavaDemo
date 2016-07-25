package york.com.retrofit2rxjavademo.http;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by York on 2016/7/23.
 */
public class ServiceFactory {
    public static final String OLD_BASE_URL = "https://liangfeizc.com/gw/oauthentry/";
//    public static final String NEW_BASE_URL = "https://liangfei.me/api/oauthentry/";
    public static final String NEW_BASE_URL = "https://api.douban.com/v2/movie/";
    private static final int DEFAULT_TIMEOUT = 5;
    private static Retrofit sRetrefit;
    private static OkHttpClient sClient;




    static {
        sClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        HttpUrl url = request.url().newBuilder()
                                .build();
                        request = request.newBuilder().url(url).build();
                        return chain.proceed(request);
                    }
                })
                .build();

         sRetrefit = new Retrofit.Builder()
                .client(sClient)
                .baseUrl(NEW_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
    public static <T> T createOldService(Class<T> serviceClazz) {
        return createOauthService(OLD_BASE_URL, serviceClazz);
    }

    public static <T> T createNewService(Class<T> serviceClazz) {
        return createOauthService(NEW_BASE_URL, serviceClazz);
    }

    public static <T> T createOauthService(Class<T> serviceClazz) {

        return sRetrefit.create(serviceClazz);
    }

    public static <T> T createOauthService(String baseUrl, Class<T> serviceClazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(sClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(serviceClazz);
    }
}
