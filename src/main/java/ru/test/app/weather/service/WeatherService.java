package ru.test.app.weather.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.test.app.weather.client.WeatherClient;
import ru.test.app.weather.dto.ResponseWeatherDto;
import ru.test.app.weather.dto.WeatherDto;
import ru.test.app.weather.mapper.WeatherMapper;
import ru.test.app.weather.persistance.entity.Weather;
import ru.test.app.weather.persistance.repository.WeatherRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class WeatherService {

    private final String appId;
    private final WeatherMapper weatherMapper;
    private final WeatherClient weatherClient;
    private final WeatherRepository weatherRepository;

    public WeatherService(@Value(value = "${weather.app_id}") String appId, WeatherMapper weatherMapper, WeatherClient weatherClient, WeatherRepository weatherRepository) {
        this.appId = appId;
        this.weatherMapper = weatherMapper;
        this.weatherClient = weatherClient;
        this.weatherRepository = weatherRepository;
    }

    @Transactional
    public ResponseWeatherDto findAll(BigDecimal latitude, BigDecimal longitude) {
        int oneDayAgo =  (int) ((System.currentTimeMillis() / 1000L) - 86400);

        Optional<Weather> weather = weatherRepository.findByLonAndLatAndDtIsGreaterThanEqual(longitude, latitude, oneDayAgo);

        if(weather.isPresent()){
            return weatherMapper.entityToResponseDto(weather.get());
        }

        WeatherDto weatherDto = weatherClient.getWeather(longitude, latitude, appId);
        Weather newWeather = weatherRepository.save(weatherMapper.dtoToEntity(weatherDto));

        return weatherMapper.entityToResponseDto(newWeather);
    }

}
