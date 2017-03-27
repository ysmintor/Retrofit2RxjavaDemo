package york.com.retrofit2rxjavademo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import york.com.retrofit2rxjavademo.R;
import york.com.retrofit2rxjavademo.entity.MockBean;
import york.com.retrofit2rxjavademo.http.ServiceFactory;
import york.com.retrofit2rxjavademo.http.exception.ApiException;
import york.com.retrofit2rxjavademo.subscribers.CommonSubscriber;
import york.com.retrofit2rxjavademo.subscribers.RxSubscriber;
import york.com.retrofit2rxjavademo.transformer.DefaultTransformer;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";
    @Bind(R.id.tv_result_one)
    TextView resultOne;
    @Bind(R.id.tv_result_two)
    TextView resultTwo;
    @Bind(R.id.btn_rxsubscriber)
    Button mBtnRxsubscriber;
    @Bind(R.id.btn_common)
    Button mBtnCommon;
    @Bind(R.id.btn_converter)
    Button mBtnConverter;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;
        Log.w(TAG, "onCreate: aa" );
    }

    @OnClick({R.id.btn_rxsubscriber, R.id.btn_common, R.id.btn_converter, R.id.btn_error})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_rxsubscriber:
                withDialog();
                break;
            case R.id.btn_common:
                withoutDialog();
                break;
            case R.id.btn_converter:
                MockDataActivity.start(this);
                break;
            case R.id.btn_error:
                showError();
                break;
        }
    }
    // Example use with CommonSubscriber which does not contain progress bar
    private void withoutDialog() {
        ServiceFactory.mockApi()
                .getMock1()
                .compose(new DefaultTransformer<List<MockBean>>())
                .subscribe(new CommonSubscriber<List<MockBean>>(mContext) {
                    // 必须重写
                    @Override
                    public void onNext(List<MockBean> mockBeen) {
                        Toast.makeText(mContext, "onNext", Toast.LENGTH_SHORT).show();
                        resultTwo.setText("begin >>>>>>>>>>>>>>>>.\n" + mockBeen);
                        Log.d("main", "onNext: " + mockBeen);
                    }

                    // 若无自定义的需求可以不用重写
                    // !!!!注意参数为ApiException 类型
                    @Override
                    protected void onError(ApiException ex) {
                        super.onError(ex);
                        Toast.makeText(mContext, "onError " + " exception code =" + ex.code + "exception message = " + ex.message, Toast.LENGTH_SHORT).show();
                    }

                    // 若无自定义的需求可以不用重写
                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                        Toast.makeText(mContext, "onCompleted", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    // Example use with RxSubscriber which contains progress bar
    private void withDialog() {
        ServiceFactory.mockApi()
                .getMock4()
                .compose(new DefaultTransformer<MockBean>())
                .subscribe(new RxSubscriber<MockBean>(mContext) {
                    // 必须重写
                    @Override
                    public void onNext(MockBean mockBean) {
                        Toast.makeText(mContext, "onNext", Toast.LENGTH_SHORT).show();
                        resultOne.setText("Single bean begin >>>>>>>>>>>>>>>>.\n" + mockBean);
                        Log.d("main", "onNext: " + mockBean);
                    }
                });
    }

    private void showError() {
        ServiceFactory.mockApi()
                .getMock2()
                .compose(new DefaultTransformer<MockBean>())
                .subscribe(new CommonSubscriber<MockBean>(mContext) {
                    @Override
                    public void onNext(MockBean mockBean) {
                        resultOne.setText("Single bean begin >>>>>>>>>>>>>>>>." + mockBean);
                    }
                });
    }
}
