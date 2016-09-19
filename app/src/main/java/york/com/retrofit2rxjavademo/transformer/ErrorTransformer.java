package york.com.retrofit2rxjavademo.transformer;


import rx.Observable;
import rx.functions.Func1;
import york.com.retrofit2rxjavademo.entity.HttpResult;
import york.com.retrofit2rxjavademo.http.ExceptionEngine;
import york.com.retrofit2rxjavademo.http.exception.ErrorType;
import york.com.retrofit2rxjavademo.http.exception.ServerException;

/**
 * Created by York on 2016/7/23.
 * 加入了对错误处理，已经比较完整了
 */
public class ErrorTransformer<T> implements Observable.Transformer<HttpResult<T>, T>{

    @Override
    public Observable<T> call(Observable<HttpResult<T>> responseObservable) {
        return responseObservable.map(new Func1<HttpResult<T>, T>() {
            @Override
            public T call(HttpResult<T> httpResult) {
                // 通过对返回码进行业务判断决定是返回错误还是正常取数据
//                if (httpResult.getCode() != 200) throw new RuntimeException(httpResult.getMessage());
                if (httpResult.getCode() != ErrorType.SUCCESS) throw new ServerException(httpResult.getMessage(), httpResult.getCode());
                return httpResult.getData();
            }
        }).onErrorResumeNext(new Func1<Throwable, Observable<? extends T>>() {
            @Override
            public Observable<? extends T> call(Throwable throwable) {
                //ExceptionEngine为处理异常的驱动器
                throwable.printStackTrace();
                return Observable.error(ExceptionEngine.handleException(throwable));
            }
        });
    }

    public static <T> ErrorTransformer<T> create() {
        return new ErrorTransformer<>();
    }

    private static ErrorTransformer instance = null;

    private ErrorTransformer(){
    }
    /**
     * 双重校验锁单例(线程安全)
     */
    public static <T>ErrorTransformer<T> getInstance() {
        if (instance == null) {
            synchronized (ErrorTransformer.class) {
                if (instance == null) {
                    instance = new ErrorTransformer<>();
                }
            }
        }
        return instance;
    }
}
