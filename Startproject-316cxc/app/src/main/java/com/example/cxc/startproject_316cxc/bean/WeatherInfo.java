package com.example.cxc.startproject_316cxc.bean;

/**
 * Created by Cxc on 2017/3/14.
 */

public class WeatherInfo {
    private String city;
    private String temp;
    private String WD;//风向
    private String WS;//风俗
    private String SD;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWD() {
        return WD;
    }

    public void setWD(String WD) {
        this.WD = WD;
    }

    public String getSD() {
        return SD;
    }

    public void setSD(String SD) {
        this.SD = SD;
    }
}
