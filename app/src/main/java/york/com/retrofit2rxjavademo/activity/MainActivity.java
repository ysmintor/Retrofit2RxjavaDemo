package york.com.retrofit2rxjavademo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import york.com.retrofit2rxjavademo.R;
import york.com.retrofit2rxjavademo.entity.ContentBean;
import york.com.retrofit2rxjavademo.http.ServiceFactory;
import york.com.retrofit2rxjavademo.http.exception.ApiException;
import york.com.retrofit2rxjavademo.subscribers.CommonSubscriber;
import york.com.retrofit2rxjavademo.subscribers.RxSubscriber;
import york.com.retrofit2rxjavademo.transformer.DefaultTransformer;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv_result_one)
    TextView resultOne;

    @Bind(R.id.tv_result_two)
    TextView resultTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        MockDataActivity.start(this);
    }

    @OnClick({R.id.btn_rxsubscriber, R.id.btn_common})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_rxsubscriber:
                ServiceFactory.movieApi()
                        .getTopMovie(0, 10)
                        .compose(new DefaultTransformer<List<ContentBean>>())
                        .subscribe(new RxSubscriber<List<ContentBean>>(this) {
                            // 必须重写
                            @Override
                            public void onNext(List<ContentBean> contentBeen) {
                                Toast.makeText(MainActivity.this, "onNext", Toast.LENGTH_SHORT).show();
                                resultOne.setText("begin >>>>>>>>>>>>>>>>." + contentBeen);
                                Log.d("main", "onNext: " + contentBeen);
                                Toast.makeText(MainActivity.this, "onNext content = " + contentBeen, Toast.LENGTH_SHORT).show();
                            }


                            // 无需设置可以不用重写
                            // !!!!注意参数为ApiException 类型，要不要写在Throwable那个了
                            @Override
                            protected void onError(ApiException ex) {
                                super.onError(ex);
                                Toast.makeText(MainActivity.this, "onError " + " exception code =" + ex.code + "exception message = " + ex.message, Toast.LENGTH_SHORT).show();
                            }

                            // 无需设置可以不用重写
                            @Override
                            public void onCompleted() {
                                super.onCompleted();
                                Toast.makeText(MainActivity.this, "onCompleted", Toast.LENGTH_SHORT).show();
                            }
                        });
                break;
            case R.id.btn_common:
                ServiceFactory.movieApi()
                        .getTopMovie(1, 10)
                        .compose(new DefaultTransformer<List<ContentBean>>())
                        .subscribe(new CommonSubscriber<List<ContentBean>>(this) {
                            // 必须重写
                            @Override
                            public void onNext(List<ContentBean> contentBeen) {
                                Toast.makeText(MainActivity.this, "onNext", Toast.LENGTH_SHORT).show();
                                resultTwo.setText("begin >>>>>>>>>>>>>>>>." + contentBeen);
                                Log.d("main", "onNext: " + contentBeen);
                                Toast.makeText(MainActivity.this, "onNext content = " + contentBeen, Toast.LENGTH_SHORT).show();
                            }


                            // 无需设置可以不用重写
                            // !!!!注意参数为ApiException 类型，要不要写在Throwable那个了
                            @Override
                            protected void onError(ApiException ex) {
                                super.onError(ex);
                                Toast.makeText(MainActivity.this, "onError " + " exception code =" + ex.code + "exception message = " + ex.message, Toast.LENGTH_SHORT).show();
                            }

                            // 无需设置可以不用重写
                            @Override
                            public void onCompleted() {
                                super.onCompleted();
                                Toast.makeText(MainActivity.this, "onCompleted", Toast.LENGTH_SHORT).show();
                            }
                        });
                break;
        }
    }
}
