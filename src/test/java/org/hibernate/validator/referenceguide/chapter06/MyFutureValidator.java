package org.hibernate.validator.referenceguide.chapter06;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidator;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorInitializationContext;

import javax.validation.ConstraintValidatorContext;
import javax.validation.metadata.ConstraintDescriptor;
import java.time.Clock;
import java.time.Instant;

public class MyFutureValidator implements HibernateConstraintValidator<MyFuture,Instant> {

    private Clock clock;

    private boolean orPresent;

    @Override
    public boolean isValid(Instant value, ConstraintValidatorContext context) {
        return false;
    }

    @Override
    public void initialize(ConstraintDescriptor<MyFuture> constraintDescriptor, HibernateConstraintValidatorInitializationContext initializationContext) {
//        this.orPresent = constraintDescriptor.getAnnotation().orPresent();
        this.clock = initializationContext.getClockProvider().getClock();
    }
}
