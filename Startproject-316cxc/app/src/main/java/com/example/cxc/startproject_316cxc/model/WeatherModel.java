package com.example.cxc.startproject_316cxc.model;

import com.example.cxc.startproject_316cxc.bean.WeatherResult;
import com.example.cxc.startproject_316cxc.iface.WeatherListener;
import com.example.cxc.startproject_316cxc.iface.Weatheriface;
import com.example.cxc.startproject_316cxc.service.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Cxc on 2017/3/14.
 */

public class WeatherModel implements Weatheriface{
    private Retrofit retrofit;
    private String BASEURL="http://www.weather.com.cn/";
    public WeatherModel() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)//主机地址
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public void getWeather(String cityno, final WeatherListener listener) {
        WeatherService weatherService = retrofit.create(WeatherService.class);
        Call<WeatherResult> call = weatherService.getResult(cityno);
        call.enqueue(new Callback<WeatherResult>() {
            @Override
            public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {

                if (response.isSuccessful()&&response.body()!=null)
                listener.onResponse(response.body().getWeatherinfo());
                else
                    listener.OnFail("onResponse error");
            }

            @Override
            public void onFailure(Call<WeatherResult> call, Throwable t) {
                listener.OnFail(t.toString());
            }
        });


    }
}
