package com.example.crxc.funny.inter.services;

import com.example.crxc.funny.bean.JokeMode;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by crxc on 2016/7/7.
 */
public interface JokeApi {
    @GET("text.from")
    Observable<JokeMode> getItem(@Query("key")String key,
                                 @Query("page")int page,
                                 @Query("pagesize")int pagesize);
}
