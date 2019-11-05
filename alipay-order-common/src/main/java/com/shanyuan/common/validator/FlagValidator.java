package com.shanyuan.common.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 9:35
 * <p>
 * desc
 **/
@Documented
@Retention( RetentionPolicy.RUNTIME )
@Target( {ElementType.FIELD,ElementType.PARAMETER} )
@Constraint( validatedBy=FlagVlidatorMethod.class )
public @interface FlagValidator {
     String [] value() default "";
     String message() default "flag not found";
     Class<?>[] groups() default {};
     Class<? extends Payload>[] payload() default {};
}
