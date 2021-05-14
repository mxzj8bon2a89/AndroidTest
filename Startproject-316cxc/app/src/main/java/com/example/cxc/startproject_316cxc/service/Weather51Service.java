package com.example.cxc.startproject_316cxc.service;

import com.example.cxc.startproject_316cxc.bean.WeatherResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Cxc on 2017/3/14.
 */

//retrofit网络访问
public interface Weather51Service {
    @GET("GetMoreWeather")
    Call<WeatherResult> getResult(
            @Query("cityCode")String cityNumber,
            @Query("weatherType")int weatherType
    );
}
