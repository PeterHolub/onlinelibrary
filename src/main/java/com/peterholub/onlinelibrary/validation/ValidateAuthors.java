package com.peterholub.onlinelibrary.validation;

import com.peterholub.onlinelibrary.validation.impl.GenresValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GenresValidator.class)
public @interface ValidateAuthors {

    String message() default "Author or authors doesnt exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
