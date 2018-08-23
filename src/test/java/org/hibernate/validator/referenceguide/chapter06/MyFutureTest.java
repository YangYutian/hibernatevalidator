package org.hibernate.validator.referenceguide.chapter06;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorFactory;
import org.junit.BeforeClass;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class MyFutureTest {
    private static Validator validator;

//    @BeforeClass
//    public static void setUpValidator(){
//        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class).configure().constraintValidatorPayload("US").buildValidatorFactory();
//        Validator validator = validatorFactory.getValidator();
//    }

    @BeforeClass
    public static void setUpValidator(){
        HibernateValidatorFactory hibernateValidatorFactory = Validation.byDefaultProvider().configure().buildValidatorFactory().unwrap(HibernateValidatorFactory.class);
        Validator validator = hibernateValidatorFactory.usingContext().constraintValidatorPayload("US").getValidator();

        validator = hibernateValidatorFactory.usingContext().constraintValidatorPayload("FR").getValidator();
    }
}
