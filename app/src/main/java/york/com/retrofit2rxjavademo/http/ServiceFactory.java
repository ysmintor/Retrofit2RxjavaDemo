package york.com.retrofit2rxjavademo.http;

import javax.inject.Inject;
import javax.inject.Named;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import york.com.retrofit2rxjavademo.di.scope.AppScope;
import york.com.retrofit2rxjavademo.di.scope.NetworkScope;

/**
 * Created by York on 2016/7/23.
 */
@AppScope
public class ServiceFactory {

/*
    public static final String BASE_URL = "http://rap.taobao.org/mockjsdata/15987/";
    private static final int DEFAULT_TIMEOUT = 10;
*/
    private final Retrofit mRetrofit;
    private final Retrofit mCustomConverterRetrofit;

    @Inject
    public ServiceFactory(Retrofit retrofit, @Named("custom_converter") Retrofit customConverterRetrofit) {
        this.mRetrofit = retrofit;
        this.mCustomConverterRetrofit = customConverterRetrofit;
    }


    public  <T> T createService(Class<T> serviceClazz) {
        return mRetrofit.create(serviceClazz);
    }

    public  <T> T createService( Retrofit retrofit, Class<T> serviceClazz) {
        return retrofit.create(serviceClazz);
    }




    /**
     * 创建
     *
     * @param serviceClazz
     * @param okHttpClient 外部传入自定义okhttp，如上传文件时加长timeout时间
     * @param <T>
     * @return
     * dagger2 中通过不同的Retrofit实例来实现
     */
/*    public <T> T createService(Class<T> serviceClazz, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(serviceClazz);
    }*/

    /**
     * 向外部提供api请求
     * @return
     */
    public MovieService movieApi() {
        return createService(MovieService.class);
    }

    public MockApi mockApi() {
        return createService(MockApi.class);
    }

    /**
     * 解决返回message在data字段
     * @return
     */
    public MockApi mockApi2() {
        return createService(mCustomConverterRetrofit, MockApi.class);
    }
}
