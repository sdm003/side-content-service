package ru.test.app.weather.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.test.app.weather.config.FeignClientConfiguration;
import ru.test.app.weather.dto.WeatherDto;

import java.math.BigDecimal;

/**
 * Клиент-сервис для выполнения запросов в weather
 */
@FeignClient(name = "WeatherClient", url = "${weather.url}/weather", configuration = FeignClientConfiguration.class)
public interface WeatherClient {
    @GetMapping()
    WeatherDto getWeather(@RequestParam BigDecimal lon, @RequestParam BigDecimal lat, @RequestParam String appId);

}
