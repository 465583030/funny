package com.example.crxc.funny.inter;
import com.example.crxc.funny.JokeApi;
import com.example.crxc.funny.JokeMode;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by crxc on 2016/7/9.
 */
public class JokeInterImpl implements JokeInter {
    public static final String BASE_URL ="http://japi.juhe.cn/joke/content/";
    private static final int DEFAULT_TIMEOUT=5;
    private Retrofit retrofit;
    private JokeApi jokeServices;

    public JokeInterImpl() {
        OkHttpClient.Builder httpClientBulider=new OkHttpClient.Builder();
        httpClientBulider.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit=new Retrofit.Builder()
                .client(httpClientBulider.build())
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        jokeServices=retrofit.create(JokeApi.class);
    }
    private static class SingletonHolder{
        private static final JokeInterImpl INSTANCE=new JokeInterImpl();
    }
    public static JokeInterImpl getIntance(){
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void getJoke(Subscriber<JokeMode> subscriber,String key, int page, int pageSize) {
        jokeServices.getItem(key,page,pageSize)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
