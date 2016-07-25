package york.com.retrofit2rxjavademo.http;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import york.com.retrofit2rxjavademo.utils.OkHttpUtils;

/**
 * Created by York on 2016/7/23.
 */
public class ServiceFactory {
    public static final String OLD_BASE_URL = "https://liangfeizc.com/gw/oauthentry/";
//    public static final String NEW_BASE_URL = "https://liangfei.me/api/oauthentry/";
    public static final String NEW_BASE_URL = "https://api.douban.com/v2/movie/";
    private static final int DEFAULT_TIMEOUT = 10;
    private static Retrofit sRetrefit;
    private static OkHttpClient sClient;




    static {
         sClient = OkHttpUtils.getOkHttpClient();

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
