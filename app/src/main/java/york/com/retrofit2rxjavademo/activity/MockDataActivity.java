package york.com.retrofit2rxjavademo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import york.com.retrofit2rxjavademo.R;
import york.com.retrofit2rxjavademo.entity.MockBean;
import york.com.retrofit2rxjavademo.http.ServiceFactory;
import york.com.retrofit2rxjavademo.subscribers.RxSubscriber;
import york.com.retrofit2rxjavademo.transformer.DefaultTransformer;

public class MockDataActivity extends AppCompatActivity {
    private TextView mTv;
    private Button mBtn1;
    private Button mBtn2;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mock_data);
        mContext = this;
        mTv = (TextView) findViewById(R.id.textView);
        mBtn1 = (Button) findViewById(R.id.button);
        mBtn2 = (Button) findViewById(R.id.button2);

        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServiceFactory.mockApi()
                        .getMock()
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
                ServiceFactory.mockApi()
                        .getMock2()
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
