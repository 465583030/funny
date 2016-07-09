package com.example.crxc.funny;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by crxc on 2016/7/7.
 */
interface gitapi {
    @GET("text.from")
    Call<GitMode> getFeed(@Path("user") String user);
}
