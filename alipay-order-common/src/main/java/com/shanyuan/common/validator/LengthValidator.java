package com.shanyuan.common.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-25 16:07
 * <p>
 * desc
 **/
@Documented
@Retention( RetentionPolicy.RUNTIME )
@Target( {ElementType.FIELD,ElementType.PARAMETER} )
@Constraint( validatedBy=LengthVlidatortMethod.class )
public @interface LengthValidator {
    long value() default 0;
    String message() default "message not found";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
