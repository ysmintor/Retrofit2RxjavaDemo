package york.com.retrofit2rxjavademo.subscribers;

import rx.Subscriber;
import york.com.retrofit2rxjavademo.http.exception.ApiException;

/**
 * @author YorkYu
 * @version V1.0
 * @Project: Retrofit2RxjavaDemo
 * @Package york.com.retrofit2rxjavademo.subscribers
 * @Description:
 * @time 2016/8/11 10:48
 */
public abstract class BaseSubscriber<T> extends Subscriber<T> {
    @Override
    public void onError(Throwable e) {
        if(e instanceof ApiException){
            onError((ApiException)e);
        }else{
            onError(new ApiException(e,1000));
        }
    }

    /**
     * 错误回调
     */
    protected abstract void onError(ApiException ex);
}