package ru.test.app.weather.config;

import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;

/**
 * Конфигурация для сваггера
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi oldApi() {
        return GroupedOpenApi.builder()
                             .group("current-api")
                             .displayName("Текущее API")
                             .packagesToScan("ru.test.app.weather.web")
                             .addOperationCustomizer((Operation operation, HandlerMethod handlerMethod) -> operation.addParametersItem(new Parameter()))
                             .build();
    }
}
