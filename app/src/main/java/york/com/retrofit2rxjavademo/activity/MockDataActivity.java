package york.com.retrofit2rxjavademo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import york.com.retrofit2rxjavademo.R;
import york.com.retrofit2rxjavademo.entity.MockBean;
import york.com.retrofit2rxjavademo.gsonconverter.CustomGsonConverterFactory;
import york.com.retrofit2rxjavademo.http.ServiceFactory;
import york.com.retrofit2rxjavademo.subscribers.RxSubscriber;
import york.com.retrofit2rxjavademo.transformer.DefaultTransformer;


public class MockDataActivity extends AppCompatActivity {
    private TextView mTv;
    private Button mBtn1;
    private Button mBtn2;
    private Context mContext;


    @Inject
    ServiceFactory mServiceFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mock_data);
        mContext = this;
        mTv = (TextView) findViewById(R.id.textView);
        mBtn1 = (Button) findViewById(R.id.button);
        mBtn2 = (Button) findViewById(R.id.button2);


        // 使用自定义Converter处理message在错误时返回在data字段
 /*       sRetrefit = new Retrofit.Builder()
                .client(ServiceFactory.getOkHttpClient())
                .baseUrl(BASE_URL)
                // 使用自定义Converter处理message在错误时返回在data字段
                .addConverterFactory(CustomGsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();*/

        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mServiceFactory.mockApi2()
                        .getMock3()
                        .compose(new DefaultTransformer<MockBean>())
                        .subscribe(new RxSubscriber<MockBean>(mContext) {
                            @Override
                            public void onNext(MockBean mockBean) {
                                mTv.setText(mockBean.toString());
                            }
                        });
            }
        });

        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mServiceFactory.mockApi2()
                        .getMock4()
                        .compose(new DefaultTransformer<MockBean>())
                        .subscribe(new RxSubscriber<MockBean>(mContext) {
                            @Override
                            public void onNext(MockBean mockBean) {
                                mTv.setText(mockBean.toString());
                            }
                        });
            }
        });
    }



    public static void start(Context context) {
        Intent starter = new Intent(context, MockDataActivity.class);
        context.startActivity(starter);
    }
}
