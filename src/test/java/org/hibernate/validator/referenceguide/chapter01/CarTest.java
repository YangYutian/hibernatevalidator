package org.hibernate.validator.referenceguide.chapter01;

import org.hibernate.validator.HibernateValidator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class CarTest {
    private static Validator validator;
    private static ValidatorFactory factory;

    @AfterClass
    public static void tearDown() throws Exception {
        factory.close();
    }

    @BeforeClass
    public static void setUpValidator(){
//        factory = Validation.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory();
        factory = Validation.buildDefaultValidatorFactory();
//        factory = Validation.byProvider(HibernateValidator.class).configure().addProperty("hibernate.validator.fail_fast","true").buildValidatorFactory();
//        factory = Validation.byProvider(HibernateValidator.class).configure().buildValidatorFactory();
        validator = factory.getValidator();
    }



    @Test
    public void manufacturerIsNull(){
        Car car = new Car("BMW","DD-AB-123",4);
        List<String> list = new ArrayList<>();
//        List<String> list = null;
        list.add("01b383602ca44db9b1d6c0274e26a3A8");
        list.add("03e5e57e58cd47238e604085da12da3a");
        list.add("03e5e57e58cd47238e604085da12da3a");
        car.setList(list);
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
        Iterator<ConstraintViolation<Car>> it = constraintViolations.iterator();
        if (it.hasNext()){
            while (it.hasNext()){
                ConstraintViolation<Car> carConstraintViolation =  it.next();
                String message = carConstraintViolation.getMessage();
                System.out.println(message);
            }
        }
//        assertEquals(1,constraintViolations.size());
    }

    @Test
    public void licensePlateTooShort() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date buyTime = simpleDateFormat.parse("2018/08/21");
        List<String> list = null;
//        list.add("hhhhhh");
//        list.add("cccccc");
//        list.add("dddddd");

        Car car = new Car( "Ford", "DDD", 4 ,buyTime);
        car.setList(list);

        Set<ConstraintViolation<Car>> constraintViolations =
                validator.validate( car );

//        assertEquals( 1, constraintViolations.size() );
//        assertEquals( "size must be between 2 and 14",constraintViolations.iterator().next().getMessage());
        Iterator<ConstraintViolation<Car>> it = constraintViolations.iterator();
        while (it.hasNext()){
           ConstraintViolation<Car> c = it.next();
            System.out.println(c.getMessage());
        }
    }

    @Test
    public void seatCountTooLow() {
        Car car = new Car( "Morris", "DD-AB-123", 1 );

        Set<ConstraintViolation<Car>> constraintViolations =
                validator.validate( car );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "must be greater than or equal to 2",
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    public void carIsValid() {
        Car car = new Car( "Morris", "DD-AB-123", 2 );

        Set<ConstraintViolation<Car>> constraintViolations =
                validator.validate( car );

        assertEquals( 0, constraintViolations.size() );
    }

}
