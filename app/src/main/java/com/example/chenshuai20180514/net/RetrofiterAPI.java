package com.example.chenshuai20180514.net;

import com.example.chenshuai20180514.bean.MyBean;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by 不将就 on 2018/5/14.
 */

public interface RetrofiterAPI {

    @POST("quarter/getJokes")
    Observable<MyBean> qq(@Query("source")
                                  String source,
                          @Query("appVersion")
                                  String appVersion,
                          @Query("page")
                                  String page);


}
