package york.com.retrofit2rxjavademo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observer;
import york.com.retrofit2rxjavademo.R;
import york.com.retrofit2rxjavademo.entity.ContentBean;
import york.com.retrofit2rxjavademo.http.MovieService;
import york.com.retrofit2rxjavademo.http.ServiceFactory;
import york.com.retrofit2rxjavademo.subscribers.SubscriberOnNextListener;
import york.com.retrofit2rxjavademo.transformer.DefaultTransformer;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.click_me_BN)
    Button clickMeBN;
    @Bind(R.id.result_TV)
    TextView resultTV;

    private SubscriberOnNextListener getTopMovieOnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        getTopMovieOnNext = new SubscriberOnNextListener<List<ContentBean>>() {
//            @Override
//            public void onNext(List<ContentBean> subjects) {
//                resultTV.setText(subjects.toString());
//            }
//        };

    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @OnClick(R.id.click_me_BN)
    public void onClick() {
        MovieService newService = ServiceFactory.createOauthService(MovieService.class);
        newService.getTopMovie(0, 10)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .compose(new ErrorCheckTransformer<List<ContentBean>>())
                .compose(new DefaultTransformer<List<ContentBean>>())
                .subscribe(new Observer<List<ContentBean>>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(MainActivity.this, "Completed!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(List<ContentBean> subjects) {
                        Toast.makeText(MainActivity.this, "onNext", Toast.LENGTH_SHORT).show();
                        resultTV.setText("begin >>>>>>>>>>>>>>>>." + subjects.toString());
                    }
                });
    }
}
