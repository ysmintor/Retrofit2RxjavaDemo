package york.com.retrofit2rxjavademo.transformer;

import android.util.Log;

import york.com.retrofit2rxjavademo.entity.HttpResult;
import york.com.retrofit2rxjavademo.http.ApiException;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by York on 2016/7/23.
 */
public class ErrorCheckTransformer<T> implements Observable.Transformer<HttpResult<T>, T>{

    @Override
    public Observable<T> call(Observable<HttpResult<T>> httpResultObservable) {
        return httpResultObservable.map(new Func1<HttpResult<T>, T>() {
            @Override
            public T call(HttpResult<T> httpResult) {
                Log.d("Thread", "call: " + Thread.currentThread().getName());
                if (httpResult.getCount() == 0) {
                    Log.e("ErrorChecker", "call: " + "count = 0");
                    throw new ApiException(100);
                }
                return  httpResult.getData();
            }
        });
    }
    public static <T> ErrorCheckTransformer<T> create() {
        return new ErrorCheckTransformer<>();
    }
}
