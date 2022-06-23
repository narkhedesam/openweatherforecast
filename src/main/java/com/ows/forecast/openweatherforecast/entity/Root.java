package com.ows.forecast.openweatherforecast.entity;

import java.util.ArrayList;

public class Root {
    private String cod;
    private Integer message;
    private Integer cnt;
    private java.util.List<List> list = new ArrayList<List>();
    private City city;
    public String getCod() {
        return cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }
    public Integer getMessage() {
        return message;
    }
    public void setMessage(Integer message) {
        this.message = message;
    }
    public Integer getCnt() {
        return cnt;
    }
    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }
    public java.util.List<List> getList() {
        return list;
    }
    public void setList(java.util.List<List> list) {
        this.list = list;
    }
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }
}
