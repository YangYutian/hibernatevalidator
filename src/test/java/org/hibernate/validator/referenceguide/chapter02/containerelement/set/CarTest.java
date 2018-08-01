package org.hibernate.validator.referenceguide.chapter02.containerelement.set;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
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
    public  void manufacturerIsNull(){
//        Car car = new Car();
//        car.addPart( "Wheel" );
//        car.addPart( null );
//
//        Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );
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
}
