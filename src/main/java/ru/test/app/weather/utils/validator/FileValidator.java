package ru.test.app.weather.utils.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import static java.util.Objects.isNull;

/**
 * Сервис для проверки формата файла на допустимые значения
 */
public class FileValidator implements ConstraintValidator<ValidFile, MultipartFile> {

    private Collection<String> supportedTypes;
    private long maxSize;

    @Override
    public void initialize(ValidFile constraintAnnotation) {
        supportedTypes = Optional.ofNullable(constraintAnnotation.supportedTypes())
                                 .map(Set::of)
                                 .orElse(Set.of());
        maxSize = constraintAnnotation.maxSize();
    }

    /**
     * Проверка валидности файла
     *
     * @param multipartFile файл
     * @return context контекст
     */
    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext context) {
        if (isNull(multipartFile)) {
            return true;
        }
        String contentType = multipartFile.getContentType();
        long size = multipartFile.getSize();
        return isSupportedContentType(contentType) && size <= maxSize;
    }


    /**
     * Проверка на совпадение формата файла
     *
     * @param contentType формат файла
     * @return boolean
     */
    private boolean isSupportedContentType(String contentType) {
        return supportedTypes.isEmpty() || supportedTypes.contains(contentType);
    }
}