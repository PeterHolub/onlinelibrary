package com.peterholub.onlinelibrary.validation;

import com.peterholub.onlinelibrary.validation.impl.RoleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RoleValidator.class)
public @interface ValidateRole {

    String message() default "Role doesnt exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
