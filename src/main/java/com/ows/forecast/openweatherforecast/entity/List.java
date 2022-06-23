package com.ows.forecast.openweatherforecast.entity;

import java.util.ArrayList;
public class List {
    private Integer dt;
    private Main main;
    private java.util.List<Weather> weather = new ArrayList<Weather>();
    private Clouds clouds;
    private Wind wind;
    private Integer visibility;
    private Double pop;
    private Rain rain;
    private Sys sys;
    private String dtTxt;
    public Integer getDt() {
        return dt;
    }
    public void setDt(Integer dt) {
        this.dt = dt;
    }
    public Main getMain() {
        return main;
    }
    public void setMain(Main main) {
        this.main = main;
    }
    public java.util.List<Weather> getWeather() {
        return weather;
    }
    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }
    public Clouds getClouds() {
        return clouds;
    }
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }
    public Wind getWind() {
        return wind;
    }
    public void setWind(Wind wind) {
        this.wind = wind;
    }
    public Integer getVisibility() {
        return visibility;
    }
    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }
    public Double getPop() {
        return pop;
    }
    public void setPop(Double pop) {
        this.pop = pop;
    }
    public Rain getRain() {
        return rain;
    }
    public void setRain(Rain rain) {
        this.rain = rain;
    }
    public Sys getSys() {
        return sys;
    }
    public void setSys(Sys sys) {
        this.sys = sys;
    }
    public String getDtTxt() {
        return dtTxt;
    }
    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }
}
