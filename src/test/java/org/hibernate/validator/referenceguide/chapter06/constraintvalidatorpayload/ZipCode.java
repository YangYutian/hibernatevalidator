package org.hibernate.validator.referenceguide.chapter06.constraintvalidatorpayload;

import java.lang.annotation.Annotation;

public class ZipCode implements Annotation {
    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
