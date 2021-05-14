package com.example.cxc.startproject_316cxc.model;

import com.example.cxc.startproject_316cxc.iface.WeatherListener;
import com.example.cxc.startproject_316cxc.iface.Weatheriface;
import com.example.cxc.startproject_316cxc.service.Weather51Service;
import com.example.cxc.startproject_316cxc.bean.WeatherResult;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Cxc on 2017/3/14.
 */

public class Weather51Model implements Weatheriface{
    private Retrofit retrofit;
    private String BASEURL="http://weather.51wnl.com/weatherinfo/";
    public Weather51Model() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)//主机地址
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    @Override
    public void getWeather(String cityno, final WeatherListener listener) {
        Weather51Service weather51Service = retrofit.create(Weather51Service.class);
        Call<WeatherResult> call = weather51Service.getResult(cityno,1);

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
