package org.hibernate.validator.referenceguide.chapter06;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CheckCaseTest {
    private static Validator validator;

    @BeforeClass
    public static void setUpValidator(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void test1(){
        //invalid license plate
        Car car = new Car( "Morris", "DD-ab-123", 4 );
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );
//        assertEquals( 1, constraintViolations.size() );
//        assertEquals("Case mode must be UPPER.", constraintViolations.iterator().next().getMessage() );
        Iterator<ConstraintViolation<Car>> it = constraintViolations.iterator();
        while (it.hasNext()){
            ConstraintViolation<Car> carConstraintViolation =  it.next();
            String message = carConstraintViolation.getMessage();
            System.out.println(message);
        }
    }

    @Test
    public void test2(){
       Car car = new Car( "Morris", "DD-AB-123", 4 );
       Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
//       assertEquals( 0, constraintViolations.size() );
        Iterator<ConstraintViolation<Car>> it = constraintViolations.iterator();
        while (it.hasNext()){
            ConstraintViolation<Car> carConstraintViolation =  it.next();
            String message = carConstraintViolation.getMessage();
            System.out.println(message);
        }
    }


}
