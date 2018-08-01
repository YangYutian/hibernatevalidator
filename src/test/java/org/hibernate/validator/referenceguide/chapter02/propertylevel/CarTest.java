package org.hibernate.validator.referenceguide.chapter02.propertylevel;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.*;
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
    public void test1(){
        Car car = new Car(null,false);
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
         Iterator<ConstraintViolation<Car>> it = constraintViolations.iterator();
         while (it.hasNext()){
             ConstraintViolation<Car> carConstraintViolation =  it.next();
             String message = carConstraintViolation.getMessage();
             System.out.println(message);
         }
    }
    @Test
    public void test2(){
        Car car = new Car("",false);
        Set<ConstraintViolation<Car>> constraintViolations = validator.validateProperty(car,"manufacturer");
         Iterator<ConstraintViolation<Car>> it = constraintViolations.iterator();
         while (it.hasNext()){
             ConstraintViolation<Car> carConstraintViolation =  it.next();
             String message = carConstraintViolation.getMessage();
             System.out.println(message);
         }
    }

}
