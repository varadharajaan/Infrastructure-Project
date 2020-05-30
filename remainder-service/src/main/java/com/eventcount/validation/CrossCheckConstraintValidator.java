package com.eventcount.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * A constraint ToDo validator
 *
 * @author eventcount
 */
public class CrossCheckConstraintValidator implements ConstraintValidator<CheckIsValid, ValidEntity> {

    @Override
    public void initialize(CheckIsValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(ValidEntity entity, ConstraintValidatorContext context) {
        return entity.isValid();
    }
}
