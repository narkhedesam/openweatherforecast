package com.ows.forecast.openweatherforecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ows.forecast.openweatherforecast.entity.Root;
import com.ows.forecast.openweatherforecast.service.WeatherService;

@RestController
@RequestMapping("/ows")
public class OpenWeatherController {

    @Autowired
    WeatherService weatherService;


    @GetMapping("/forecast")
    private ResponseEntity<Root> getWeatherForecast(@RequestParam("city") String city, @RequestParam("country") String country) throws Exception{
        
        Root weatherDetails = weatherService.getWeatherForecastforCityAndCountry(city, country);
        
        return new ResponseEntity<Root>(weatherDetails,HttpStatus.OK);
    }

}
