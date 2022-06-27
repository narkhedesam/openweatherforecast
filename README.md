# OpenWeatherForecastBackend
Get 5 Days Weather Forecast from OpenWeatherApi

# To Start this App
Open command prompt add below commands

    mvn clean
    mvn install package

    then,

    ./mvnw spring-boot:run 

    or directly run generated jar file
    
    cd target
    java -jar <jar file name>


### Note : as Used free Db it may cause problem due to connection issue

you can set local db credentials in application.properties file

spring.datasource.url=jdbc:mysql://localhost:{port}/{DBNAME}

spring.datasource.username={USERNAME}

spring.datasource.password={PASSWORD}

Here the screenshot of stored request and response data
![COVID-19-Tracker-Application](DBSS.jpeg)
