package ru.test.app.weather.config;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

/**
 * Обработчик ошибок возникающие в FeignClient.
 */
@Slf4j
public class FeignClientErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        log.error("Error in request went through feign client");
        switch (response.status()) {
            case 400 -> {
                return handleException(response, "Bad Request exception through Feign request");
            }
            case 401 -> {
                return handleException(response, "Unauthorized Request through Feign request");
            }
            case 404 -> {
                return handleException(response, "Not found exception through Feign request");
            }
            default -> {
                log.info("Unexpected response status: '{}', URL: {}, {}", response.status(), response.request().httpMethod(), response.request().url());
                return handleException(response, "Common exception through Feign request");
            }
        }
    }

    private FeignException.FeignClientException handleException(Response response, String message) {
        return new FeignException.FeignClientException(
            response.status(),
            message,
            response.request(),
            response.request().body(),
            response.headers());
    }
}
