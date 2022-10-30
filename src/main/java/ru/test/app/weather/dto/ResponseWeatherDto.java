package ru.test.app.weather.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ResponseWeatherDto {
    @Schema(description = "Долгота", example = "23.12")
    public BigDecimal lon;
    @Schema(description = "Широта", example = "12.23")
    public BigDecimal lat;
    @Schema(description = "Текущая температура", example = "23")
    public Double temp;
    @Schema(description = "Ощущается как", example = "21")
    public Double feels_like;
    @Schema(description = "Минимальная температура", example = "20")
    public Double temp_min;
    @Schema(description = "Максимальная температура", example = "26")
    public Double temp_max;
    @Schema(description = "Время замера", example = "1667077395")
    public Integer dt;
    @Schema(description = "Город", example = "Zocca")
    public String name;
    @Schema(description = "Сокращенное название страны", example = "IT")
    public String country;
}
