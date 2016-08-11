package york.com.retrofit2rxjavademo.transformer;

import rx.Observable;
import rx.functions.Func1;
import york.com.retrofit2rxjavademo.http.ExceptionEngine;

/**
 * @author YorkYu
 * @version V1.0
 * @Project: Retrofit2RxjavaDemo
 * @Package york.com.retrofit2rxjavademo.transformer
 * @Description:    进行错误转换
 * @time 2016/8/11 15:54
 */
public class HttpResponseFunc<T> implements Func1<Throwable, Observable<T>> {
    @Override
    public Observable<T> call(Throwable throwable) {
        //ExceptionEngine为处理异常的驱动器
        return Observable.error(ExceptionEngine.handleException(throwable));
    }
}
