package ru.test.app.weather.utils.validator;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для проверки файла на формат и размер
 */

@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {FileValidator.class})
public @interface ValidFile {

    String message() default "Invalid longitude or latitude";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Поддерживаемые типы файла.
     * Укажите пустой массив если проверка не нужна.
     *
     * @return массив поддерживаемых типов
     */
    String[] supportedTypes() default {};

    /**
     * Максимально разрешенный размер загружаемого файла
     *
     * @return размер файла в байтах
     */
    long maxSize() default Long.MAX_VALUE;
}