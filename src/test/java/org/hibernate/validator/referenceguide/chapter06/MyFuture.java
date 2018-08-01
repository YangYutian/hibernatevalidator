package org.hibernate.validator.referenceguide.chapter06;

import java.lang.annotation.Annotation;

public class MyFuture implements Annotation {
    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
