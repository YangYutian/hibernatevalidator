package org.hibernate.validator.referenceguide.chapter02.containerelement.set;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CarTest {
    private static Validator validator;

    @BeforeClass
    public static void setUpValidator(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public  void test1(){
        Car car = new Car();
        car.addPart( "Wheel" );
        car.addPart( null );

        Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );
        Iterator<ConstraintViolation<Car>> it = constraintViolations.iterator();
        while (it.hasNext()){
            ConstraintViolation<Car> carConstraintViolation =  it.next();
            String message = carConstraintViolation.getMessage();
            System.out.println(message);
        }
//        assertEquals( 1, constraintViolations.size() );
//
//        ConstraintViolation<Car> constraintViolation =
//                constraintViolations.iterator().next();
//        assertEquals(
//                "'null' is not a valid car part.",
//                constraintViolation.getMessage()
//        );
//        assertEquals( "parts[].<iterable element>",
//                constraintViolation.getPropertyPath().toString() );



    }

    @Test
    public void test2(){
        Car car = new Car();
        car.addPart( "Wheel" );
        car.addPart( null );
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );
        Iterator<ConstraintViolation<Car>> it = constraintViolations.iterator();
        assertEquals( 1, constraintViolations.size() );

        ConstraintViolation<Car> constraintViolation =
                constraintViolations.iterator().next();
        assertEquals(
                "'null' is not a valid car part.",
                constraintViolation.getMessage()
        );
        assertEquals( "parts[].<iterable element>",
                constraintViolation.getPropertyPath().toString() );
    }
}
