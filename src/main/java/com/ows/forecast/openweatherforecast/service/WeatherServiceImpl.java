package com.ows.forecast.openweatherforecast.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ows.forecast.openweatherforecast.entity.Root;

@Service
public class WeatherServiceImpl implements WeatherService{

    private static final String FORECAST_URL =
			"http://api.openweathermap.org/data/2.5/forecast";

    @Value("${apiKey}")
    private String apiKey;

    @Override
    public Root getWeatherForecastforCityAndCountry(String city, String country) throws Exception{
        String queryString = "?q=" + city + "," + country + "&APPID=" + apiKey;
        Root resp;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Root> responseEntity = restTemplate.getForEntity(FORECAST_URL + queryString, Root.class);
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            resp = responseEntity.getBody(); // for future we can filter the data here
        } else {
            throw new Exception("API Failure");
        }
        return resp;
    }
    
}
