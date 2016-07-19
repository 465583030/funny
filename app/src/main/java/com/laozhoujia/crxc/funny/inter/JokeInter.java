package com.laozhoujia.crxc.funny.inter;

import com.laozhoujia.crxc.funny.bean.GifMode;
import com.laozhoujia.crxc.funny.bean.JokeMode;
import com.laozhoujia.crxc.funny.bean.RandomGifMode;
import com.laozhoujia.crxc.funny.bean.RandomJokeMode;

import rx.Subscriber;

/**
 * Created by crxc on 2016/7/9.
 */
public interface JokeInter  {
    void getJoke(Subscriber<JokeMode> subscriber, String key, int page, int pageSize);

    void getGif(Subscriber<GifMode> subscriber, String key, int page, int pageSize);

    void getRandomJoke(Subscriber<RandomJokeMode> subscriber, String key, String type);

    void getRandomGif(Subscriber<RandomGifMode> subscriber, String key, String type);
}
