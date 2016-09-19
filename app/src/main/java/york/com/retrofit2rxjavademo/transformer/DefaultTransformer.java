package york.com.retrofit2rxjavademo.transformer;


import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import york.com.retrofit2rxjavademo.entity.HttpResult;

/**
 * Created by York on 2016/7/23.
 */
public class DefaultTransformer<T>
        implements Observable.Transformer<HttpResult<T>, T> {

    @Override
    public Observable<T> call(Observable<HttpResult<T>> observable) {
        return observable
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .compose(ErrorTransformer.<T>getInstance())
                .observeOn(AndroidSchedulers.mainThread());
    }
}