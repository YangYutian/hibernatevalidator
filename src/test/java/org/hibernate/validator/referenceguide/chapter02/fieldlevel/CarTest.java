package org.hibernate.validator.referenceguide.chapter02.fieldlevel;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

public class CarTest {
    private static Validator validator;

    @BeforeClass
    public static void setUpValidator(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void manufacturerIsNull(){
        Car car = new Car(null,true);
        Set<ConstraintViolation<Car>> constraintViolations =  validator.validate(car);
        Iterator<ConstraintViolation<Car>> it = constraintViolations.iterator();
        while (it.hasNext()){
            ConstraintViolation<Car> c = it.next();
            System.out.println(c.getMessage());
        }
    }

    @Test
    public void isRegistered(){
        Car car = new Car("Ford",false);
        Set<ConstraintViolation<Car>> constraintViolations =  validator.validate(car);
        Iterator<ConstraintViolation<Car>> it = constraintViolations.iterator();
        while (it.hasNext()){
            ConstraintViolation<Car> c = it.next();
            System.out.println(c.getMessage());
        }
    }
}
