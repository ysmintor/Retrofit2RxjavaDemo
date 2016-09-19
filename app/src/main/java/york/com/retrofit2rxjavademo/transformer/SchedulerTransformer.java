package york.com.retrofit2rxjavademo.transformer;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by York on 2016/7/23.
 */
public class SchedulerTransformer<T> implements Observable.Transformer<T, T> {
    @Override
    public Observable<T> call(Observable<T> observable) {
        return observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> SchedulerTransformer<T> create() {
        return new SchedulerTransformer<>();
    }

    private static SchedulerTransformer instance = null;

    private SchedulerTransformer(){
    }
    /**
     * 双重校验锁单例(线程安全)
     */
    public static<T> SchedulerTransformer<T> getInstance() {
        if (instance == null) {
            synchronized (SchedulerTransformer.class) {
                if (instance == null) {
                    instance = new SchedulerTransformer<>();
                }
            }
        }
        return instance;
    }
}