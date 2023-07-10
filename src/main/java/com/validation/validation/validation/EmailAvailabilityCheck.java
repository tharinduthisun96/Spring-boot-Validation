package com.validation.validation.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailValidator.class )
public @interface EmailAvailabilityCheck {
    public String message() default "Email is already exist";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
