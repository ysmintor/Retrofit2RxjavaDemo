package york.com.retrofit2rxjavademo;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import york.com.retrofit2rxjavademo.di.component.DaggerAppComponent;
import york.com.retrofit2rxjavademo.di.module.NetworkModule;

/**
 * @author YorkYu
 * @version V1.0
 * @Project: Retrofit2RxjavaDemo
 * @Package york.com.retrofit2rxjavademo
 * @Description:
 * @time 2016/7/25 17:08
 */
public class MyApplication extends Application implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    private static final String sBASE_URL = "http://rap.taobao.org/mockjsdata/15987/";
    private static final int sDEFAULT_TIMEOUT = 10;

    @Override
    public void onCreate() {
       super.onCreate();

        DaggerAppComponent
                .builder()
                .application(this)
                .network(new NetworkModule(sBASE_URL, sDEFAULT_TIMEOUT))
                .build()
                .inject(this);
    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
}
