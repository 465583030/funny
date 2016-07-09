package com.example.crxc.funny.inter;

import com.example.crxc.funny.JokeMode;

import rx.Subscriber;

/**
 * Created by crxc on 2016/7/9.
 */
public interface JokeInter  {
    void getJoke(Subscriber<JokeMode> subscriber,String key, int page, int pageSize);
}
