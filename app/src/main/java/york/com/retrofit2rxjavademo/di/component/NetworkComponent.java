package york.com.retrofit2rxjavademo.di.component;

import dagger.BindsInstance;
import dagger.Subcomponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import york.com.retrofit2rxjavademo.di.module.NetworkModule;
import york.com.retrofit2rxjavademo.di.scope.NetworkScope;

/**
 * @author: YorkYu
 * @version: V2.0.0
 * @project: Retrofit2RxjavaDemo
 * @package: york.com.retrofit2rxjavademo.di.component
 * @description: description
 * @date: 2017/7/7
 * @time: 17:30
 */
@NetworkScope
@Subcomponent(modules = {NetworkModule.class})
public interface NetworkComponent {

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        Builder baseUrl(String base_url);
        NetworkComponent build();
    }

    Retrofit getRetrofit();

    OkHttpClient getOkHttpClient();
}
