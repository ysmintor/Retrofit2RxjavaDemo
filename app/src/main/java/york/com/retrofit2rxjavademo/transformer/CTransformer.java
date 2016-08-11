package york.com.retrofit2rxjavademo.transformer;

import rx.Observable;
import rx.functions.Func1;
import york.com.retrofit2rxjavademo.entity.HttpResult;

/**
 * Created by York on 2016/7/23.
 * 加入了对错误处理，已经比较完整了
 */
public class CTransformer<T> implements Observable.Transformer<HttpResult<T>, T>{

    @Override
    public Observable<T> call(Observable<HttpResult<T>> responseObservable) {
        return responseObservable.map(new Func1<HttpResult<T>, T>() {
            @Override
            public T call(HttpResult<T> httpResult) {
                // 通过对返回码进行业务判断决定是返回错误还是正常取数据
                if (httpResult.getCode() != 200) throw new RuntimeException(httpResult.getMessage());
                return httpResult.getData();
            }
        }).onErrorResumeNext(new HttpResponseFunc<T>());
    }

    public static <T> CTransformer<T> create() {
        return new CTransformer<>();
    }

}
