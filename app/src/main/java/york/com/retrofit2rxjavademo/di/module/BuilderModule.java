package york.com.retrofit2rxjavademo.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import york.com.retrofit2rxjavademo.activity.MainActivity;
import york.com.retrofit2rxjavademo.di.scope.ControllerScope;

/**
 * @author: YorkYu
 * @version: V2.0.0
 * @project: Retrofit2RxjavaDemo
 * @package: york.com.retrofit2rxjavademo.di.module
 * @description: description
 * @date: 2017/7/11
 * @time: 11:45
 */
@Module
public abstract class BuilderModule {
    @ContributesAndroidInjector()
    abstract MainActivity contributeMainActivityInjector();
}
