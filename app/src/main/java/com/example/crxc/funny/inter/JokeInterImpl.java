package com.example.crxc.funny.inter;
import com.example.crxc.funny.bean.GifMode;
import com.example.crxc.funny.inter.services.GifApi;
import com.example.crxc.funny.inter.services.JokeApi;
import com.example.crxc.funny.bean.JokeMode;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by crxc on 2016/7/9.
 */
public class JokeInterImpl implements JokeInter {
    public static final String BASE_URL ="http://japi.juhe.cn/joke/content/";
    public static final String GIF_BASE_URL ="http://japi.juhe.cn/joke/img/";
    private static final int DEFAULT_TIMEOUT=5;
    private Retrofit retrofit;
    private JokeApi jokeServices;
    private GifApi GifServices;

    public JokeInterImpl(String baseUrl) {
        OkHttpClient.Builder httpClientBulider=new OkHttpClient.Builder();
        httpClientBulider.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit=new Retrofit.Builder()
                .client(httpClientBulider.build())
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }
    private static class SingletonHolder{
        private static final JokeInterImpl INSTANCE=new JokeInterImpl(BASE_URL);
        private static final JokeInterImpl GIFINSTANCE=new JokeInterImpl(GIF_BASE_URL);
    }
    public static JokeInterImpl getIntance(){
        return SingletonHolder.INSTANCE;
    }

    public static JokeInterImpl getGifIntance(){
        return SingletonHolder.GIFINSTANCE;
    }

    @Override
    public void getJoke(Subscriber<JokeMode> subscriber,String key, int page, int pageSize) {
        jokeServices=retrofit.create(JokeApi.class);
        jokeServices.getItem(key,page,pageSize)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void getGif(Subscriber<GifMode> subscriber, String key, int page, int pageSize) {
        GifServices=retrofit.create(GifApi.class);
        GifServices.getItem(key,page,pageSize)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
