package org.hibernate.validator.referenceguide.chapter02.containerelement.set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Set;

public class ValidPartValidator implements ConstraintValidator<ValidPart, String> {
//    private String value;
    @Override
    public void initialize(ValidPart constraintAnnotation) {
//        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.println(value);
        if (value == null){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("'null' is not a valid car part.").addConstraintViolation();
        }
        return false;
    }


}
