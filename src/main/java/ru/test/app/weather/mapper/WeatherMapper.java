package ru.test.app.weather.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.test.app.weather.dto.ResponseWeatherDto;
import ru.test.app.weather.dto.WeatherDto;
import ru.test.app.weather.persistance.entity.Weather;

/**
 * Mapper для Activity.
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface WeatherMapper {
    @Mapping(source = "main.temp", target = "temp")
    @Mapping(source = "main.feels_like", target = "feels_like")
    @Mapping(source = "main.temp_min", target = "temp_min")
    @Mapping(source = "main.temp_max", target = "temp_max")
    @Mapping(source = "sys.country", target = "country")
    @Mapping(source = "coord.lon", target = "lon")
    @Mapping(source = "coord.lat", target = "lat")
    Weather dtoToEntity(WeatherDto weatherDto);

    ResponseWeatherDto entityToResponseDto(Weather weather);

}
