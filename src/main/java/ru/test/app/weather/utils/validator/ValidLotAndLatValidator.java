package ru.test.app.weather.utils.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class ValidLotAndLatValidator implements ConstraintValidator<ValidLotAndLat, BigDecimal> {

    private int min;
    private int max;

    @Override
    public void initialize(ValidLotAndLat constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(BigDecimal o, ConstraintValidatorContext constraintValidatorContext) {
        return o.intValue() >= min && o.intValue() <= max;
    }

}
