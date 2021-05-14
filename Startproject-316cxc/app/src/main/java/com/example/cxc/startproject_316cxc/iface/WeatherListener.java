package com.example.cxc.startproject_316cxc.iface;

import com.example.cxc.startproject_316cxc.bean.WeatherInfo;

/**
 * Created by Cxc on 2017/3/14.
 */
//统一网络数据获取结果(成功/失败),定义接口
public interface WeatherListener {
    //成功返回天气信息
    void onResponse(WeatherInfo weatherInfo);
    //失败返回错误信息
    void OnFail(String msg);
}
