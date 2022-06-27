package com.ows.forecast.openweatherforecast.repository;

import com.ows.forecast.openweatherforecast.entity.RequestDbLogger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDbLoggerRepo extends JpaRepository<RequestDbLogger,Long>{
    
}
