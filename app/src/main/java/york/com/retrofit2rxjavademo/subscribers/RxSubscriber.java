package york.com.retrofit2rxjavademo.subscribers;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import york.com.retrofit2rxjavademo.activity.MainActivity;
import york.com.retrofit2rxjavademo.http.ApiException;
import york.com.retrofit2rxjavademo.utils.DialogHelper;

/**
 * @author YorkYu
 * @version V1.0
 * @Project: Retrofit2RxjavaDemo
 * @Package york.com.retrofit2rxjavademo.subscribers
 * @Description:
 * @time 2016/8/11 10:54
 */
public abstract class RxSubscriber<T> extends ErrorSubscriber<T> {
    public RxSubscriber(Context context) {
        this.mContext = context;
    }
    private static final String TAG = RxSubscriber.class.getSimpleName();
    private Context mContext;
    @Override
    public void onStart() {
        super.onStart();
        DialogHelper.showProgressDlg(mContext, "正在加载数据");
    }

    @Override
    public void onCompleted() {
        DialogHelper.stopProgressDlg();
    }

    @Override
    protected void onError(ApiException ex) {
        DialogHelper.stopProgressDlg();
        Log.d(TAG, "onError: " + ex.message + "code" + ex.code);

    }

    @Override
    public abstract void onNext(T t);
}
