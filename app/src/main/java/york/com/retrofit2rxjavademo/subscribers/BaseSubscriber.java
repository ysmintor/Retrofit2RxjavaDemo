package york.com.retrofit2rxjavademo.subscribers;

import android.content.Context;

import rx.Subscriber;

/**
 * Created by York on 2016/7/23.
 */
public abstract class BaseSubscriber<T> extends Subscriber<T> {
    private Context mContext;

    public BaseSubscriber(Context context) {
        mContext = context;
    }

    public Context getContext() {
        return mContext;
    }
}