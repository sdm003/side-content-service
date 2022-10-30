package ru.test.app.weather.utils.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * У аннотированного объекта должно быть заполнено ровно 1 поле из списка
 */
@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValidLotAndLatValidator.class})
public @interface ValidLotAndLat {

    String message() default "Invalid longitude or latitude";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     Минимально допустимое значение
     */
    int min() default -90;


    /**
     Максимально допустимое значение
     */
    int max() default 90;
}
