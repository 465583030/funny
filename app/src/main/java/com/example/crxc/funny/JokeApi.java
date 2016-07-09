package com.example.crxc.funny;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
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
