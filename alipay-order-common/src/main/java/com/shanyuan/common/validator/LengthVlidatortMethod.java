package com.shanyuan.common.validator;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-25 16:10
 * <p>
 * desc
 **/
public class LengthVlidatortMethod implements ConstraintValidator<LengthValidator,String> {

    long length;
    @Override
    public void initialize(LengthValidator constraintAnnotation) {
        this.length = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = false;
        if(!StringUtils.isEmpty( value )){
            if(value.length()<=length){
                isValid = true;
            }
        }
        return isValid;
    }



}
