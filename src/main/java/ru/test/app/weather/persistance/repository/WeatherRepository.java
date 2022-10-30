package ru.test.app.weather.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.app.weather.persistance.entity.Weather;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

/**
 * Интерфейс для репозитория для погоды.
 */
@Repository
public interface WeatherRepository extends JpaRepository<Weather, UUID> {

    Optional<Weather> findByLonAndLatAndDtIsGreaterThanEqual(BigDecimal lat, BigDecimal lon, Integer dt);
}
