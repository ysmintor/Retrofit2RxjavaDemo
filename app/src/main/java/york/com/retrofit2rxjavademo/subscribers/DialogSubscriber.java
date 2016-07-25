package york.com.retrofit2rxjavademo.subscribers;

/**
 * Created by York on 2016/7/23.
 */

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.CallSuper;
import android.support.v7.app.AlertDialog;

public abstract class DialogSubscriber<T> extends BaseSubscriber<T> {

    public DialogSubscriber(Context context) {
        super(context);
    }

    @CallSuper
    @Override
    public void onError(Throwable e) {
        new AlertDialog.Builder(getContext()).setMessage(e.getMessage()).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create().show();
    }
}
