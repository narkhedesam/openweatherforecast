package com.ows.forecast.openweatherforecast.service;

import com.ows.forecast.openweatherforecast.entity.Root;

public interface WeatherService {
    
    Root getWeatherForecastforCityAndCountry(String city, String country) throws Exception;
}
