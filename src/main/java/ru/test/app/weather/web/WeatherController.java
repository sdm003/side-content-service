package ru.test.app.weather.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.test.app.weather.dto.ResponseWeatherDto;
import ru.test.app.weather.service.WeatherService;
import ru.test.app.weather.utils.Constants;
import ru.test.app.weather.utils.validator.ValidLotAndLat;

import java.math.BigDecimal;

/**
 * Контроллер для работы с блоками для историй
 */
@Validated
@RequestMapping("/weather")
@RestController
@Tag(name = "Работа с историями")
@RequiredArgsConstructor
public class WeatherController {

    @NonNull
    private final WeatherService weatherService;

    @GetMapping()
    @Operation(summary = "Получить информацию о погоде")
    @ApiResponse(responseCode = "200", description = "Информация о погоде получена получены")
    @ApiResponse(responseCode = "400", description = Constants.HTTP_ERROR_400_DESCRIPTION, content = @Content())
    public ResponseWeatherDto getAllWeathers(
        @Parameter(description = "Широта", example = "23.23")
        @RequestParam(value = "lat", required = false) BigDecimal latitude,
        @Parameter(description = "Долгота", example = "23.23")
        @ValidLotAndLat(min = -180, max = 180) @RequestParam(value = "lon", required = false) BigDecimal longitude) {
        return weatherService.findAll(latitude, longitude);
    }
}
