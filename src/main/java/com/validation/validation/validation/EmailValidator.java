package com.validation.validation.validation;

import com.validation.validation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailAvailabilityCheck, String> {
    @Autowired
    private UserService user;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !user.emailAvailability(value);
    }
}
