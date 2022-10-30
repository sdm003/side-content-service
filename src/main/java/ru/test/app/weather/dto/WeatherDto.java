package ru.test.app.weather.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.ArrayList;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class WeatherDto {

    private Coord coord;
    private String base;
    private Main main;
    private Integer dt;
    private Sys sys;
    private String name;

    @Data
    public class Coord{
        private BigDecimal lon;
        private BigDecimal lat;
    }

    @Data
    public class Main{
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
    }

    @Data
    public class Sys{
        private String country;
    }

}
