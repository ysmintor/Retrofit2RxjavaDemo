package york.com.retrofit2rxjavademo.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import york.com.retrofit2rxjavademo.activity.MainActivity;
import york.com.retrofit2rxjavademo.activity.MockDataActivity;
import york.com.retrofit2rxjavademo.di.scope.ControllerScope;

/**
 * @author: YorkYu
 * @version: V2.0.0
 * @project: Retrofit2RxjavaDemo
 * @package: york.com.retrofit2rxjavademo.di.module
 * @description: 用来连接各个Activity Service 等
 * @date: 2017/7/11
 * @time: 11:45
 */
@Module
public abstract class InjectorModule {

    @ControllerScope
    @ContributesAndroidInjector()
    abstract MainActivity contributeMainActivityInjector();

    @ControllerScope
    @ContributesAndroidInjector()
    abstract MockDataActivity contributeMockDataActivityInjector();
}
