package york.com.retrofit2rxjavademo.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import york.com.retrofit2rxjavademo.MyApplication;
import york.com.retrofit2rxjavademo.di.scope.AppScope;

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
public class AppModule {
    @Provides
    @AppScope
    Context provideContext(MyApplication application) {
        return application.getApplicationContext();
    }
}
