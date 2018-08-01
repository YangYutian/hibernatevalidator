package org.hibernate.validator.referenceguide.chapter06.constraintvalidatorpayload;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {
    public String countryCode;
    @Override
    public void initialize(ZipCode constraintAnnotation) {

    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        if ( object == null ) {
            return true;
        }

        boolean isValid = false;

        String countryCode = constraintContext
                .unwrap( HibernateConstraintValidatorContext.class )
                .getConstraintValidatorPayload( String.class );

        if ( "US".equals( countryCode ) ) {
            // checks specific to the United States
        }
        else if ( "FR".equals( countryCode ) ) {
            // checks specific to France
        }
        else {
            // ...
        }

        return isValid;
    }
}