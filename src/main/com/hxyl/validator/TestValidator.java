package com.hxyl.validator;

public class TestValidator {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Address add = new Address();
        add.setNum(0);
        add.setStreet("1");

        Person p = new Person();
        p.setAddress(add);
        p.setAge(0);
        p.setName("ice");


    }
}
