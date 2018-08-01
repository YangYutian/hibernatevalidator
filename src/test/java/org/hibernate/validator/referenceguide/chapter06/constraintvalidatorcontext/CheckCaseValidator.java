package org.hibernate.validator.referenceguide.chapter06.constraintvalidatorcontext;

import org.hibernate.validator.referenceguide.chapter06.CaseMode;
import org.hibernate.validator.referenceguide.chapter06.CheckCase;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {

    private CaseMode caseMode;

    @Override
    public void initialize(CheckCase constraintAnnotation) {
        this.caseMode = constraintAnnotation.value();

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null){
            return true;
        }
        boolean isValid;
        if (caseMode == CaseMode.UPPER){
            isValid = s.equals(s.toUpperCase());
        }else {
            isValid = s.equals(s.toLowerCase());
        }
        if (!isValid){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("{org.hibernate.validator.referenceguide.chapter06." +
                    "constraintvalidatorcontext.CheckCase.message}").addConstraintViolation();
        }
        return isValid;
    }
}
