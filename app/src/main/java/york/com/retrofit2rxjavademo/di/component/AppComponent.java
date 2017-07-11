package york.com.retrofit2rxjavademo.di.component;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.AndroidSupportInjectionModule;
import york.com.retrofit2rxjavademo.MyApplication;
import york.com.retrofit2rxjavademo.di.module.AppModule;
import york.com.retrofit2rxjavademo.di.module.BuilderModule;
import york.com.retrofit2rxjavademo.di.module.NetworkModule;
import york.com.retrofit2rxjavademo.di.scope.AppScope;

/**
 * @author: YorkYu
 * @version: V2.0.0
 * @project: Retrofit2RxjavaDemo
 * @package: york.com.retrofit2rxjavademo.di.component
 * @description: description
 * @date: 2017/7/7
 * @time: 17:30
 */
@AppScope
@Component(modules = {
        /* Use AndroidInjectionModule.class if you're not using support library */
        AndroidInjectionModule.class,
        BuilderModule.class,
        NetworkModule.class,
        AppModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(MyApplication application);

        Builder network(NetworkModule networkModule);

        AppComponent build();
    }

    void inject(MyApplication app);
}
