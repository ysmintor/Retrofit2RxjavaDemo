package york.com.retrofit2rxjavademo.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by zhy on 15/8/17.
 * Modified by Yorkyu on 2016/7/25
 */
public class OkHttpUtils
{
    public static final long DEFAULT_MILLISECONDS = 10_000L;    // ten seconds
    private volatile static OkHttpUtils mInstance;
    private static OkHttpClient mOkHttpClient;

    public OkHttpUtils(OkHttpClient okHttpClient)
    {
        if (okHttpClient == null)
        {
            mOkHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)
                    .readTimeout(DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)
                    .addNetworkInterceptor(
                            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build();
//                    .addInterceptor(new LoggerInterceptor("TAG")).build();//zhy的

        } else
        {
            mOkHttpClient = okHttpClient;
        }

    }

    // 由外部提供OkhttpClient
    public static OkHttpUtils initClient(OkHttpClient okHttpClient)
    {
        if (mInstance == null)
        {
            synchronized (OkHttpUtils.class)
            {
                if (mInstance == null)
                {
                    mInstance = new OkHttpUtils(okHttpClient);
                }
            }
        }
        return mInstance;
    }

    public static OkHttpUtils getInstance()
    {
        return initClient(null);
    }

    public static OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }
}

