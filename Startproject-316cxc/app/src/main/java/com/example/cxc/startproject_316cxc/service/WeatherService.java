package com.example.cxc.startproject_316cxc.service;

import com.example.cxc.startproject_316cxc.bean.WeatherResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Cxc on 2017/3/14.
 */
//retrofit 访问网络 定义接口
public interface WeatherService {
    @GET("data/sk/{cityNumber}.html")
    Call<WeatherResult> getResult(@Path("cityNumber")String cityNumber);
}
