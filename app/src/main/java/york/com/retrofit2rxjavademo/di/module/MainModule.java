package york.com.retrofit2rxjavademo.di.module;

import dagger.Module;
import dagger.Provides;
import york.com.retrofit2rxjavademo.di.scope.PerActivityScope;
import york.com.retrofit2rxjavademo.entity.TestBean;

/**
 * @author: YorkYu
 * @version: V2.0.0
 * @project: Retrofit2RxjavaDemo
 * @package: york.com.retrofit2rxjavademo.di.module
 * @description: description
 * @date: 2017/7/11
 * @time: 17:45
 */
@Module
public class MainModule {
    @Provides
    @PerActivityScope
    TestBean provideTestBean() {
        return new TestBean("ma", 13);
    }
}
