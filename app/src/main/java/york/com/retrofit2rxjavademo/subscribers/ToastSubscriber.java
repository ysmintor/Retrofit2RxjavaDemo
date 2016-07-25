package york.com.retrofit2rxjavademo.subscribers;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.widget.Toast;

import york.com.retrofit2rxjavademo.subscribers.BaseSubscriber;

/**
 * Created by York on 2016/7/23.
 */
public abstract class ToastSubscriber<T> extends BaseSubscriber<T> {

    public ToastSubscriber(Context context) {
        super(context);
    }

    @CallSuper
    @Override
    public void onError(Throwable e) {
//        ToastUtil.show(getContext(), e.getMessage());
        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }
}