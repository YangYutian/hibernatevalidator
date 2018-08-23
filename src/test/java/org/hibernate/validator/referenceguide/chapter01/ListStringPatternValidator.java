package org.hibernate.validator.referenceguide.chapter01;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Iterator;
import java.util.List;

public class ListStringPatternValidator implements ConstraintValidator<ListStringPattern, List<String>> {

    private String pattern;

    @Override
    public void initialize(ListStringPattern constraintAnnotation) {
        this.pattern = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(List<String> list, ConstraintValidatorContext constraintContext) {
        System.out.println(list);
        boolean isValid = true;
        if (list == null || list.size() == 0) {
            isValid = false;
//            constraintContext.disableDefaultConstraintViolation();
//            constraintContext.buildConstraintViolationWithTemplate("List<String> is not null.").addConstraintViolation();
            return isValid;
        }

        String errorString = null;
        if (pattern == null || "".equals(pattern.trim())) {
            isValid = false;
            if (!isValid) {
//                constraintContext.disableDefaultConstraintViolation();
//                constraintContext.buildConstraintViolationWithTemplate("指定的正则表达式为空").addConstraintViolation();
            }
            return isValid;
        } else {
            Iterator<String> iter = list.iterator();
            while(iter.hasNext()){
                String string = iter.next();
                if(!string.matches(pattern)){
                    isValid = false;
//                    errorString = string;
                    break;
                }
            }
        }

        if (!isValid) {
//            constraintContext.disableDefaultConstraintViolation();
//            constraintContext.buildConstraintViolationWithTemplate("List<String>为空，或者其中的"+errorString+"不符合正则表达式："+pattern).addConstraintViolation();
        }
        return isValid;
    }
}
