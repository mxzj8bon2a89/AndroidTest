package com.example.cxc.startproject_316cxc.iface;

/**
 * Created by Cxc on 2017/3/14.
 */
//不同方式获取天气
public interface Weatheriface {
    void getWeather(String cityno,
                    WeatherListener listener);

}
