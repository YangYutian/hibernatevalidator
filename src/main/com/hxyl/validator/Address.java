package com.hxyl.validator;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


public class Address {
    private String street;
    private int num;

    public Address() {
    }

    @Length(min = 3,max = 8)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Min(value = 1)
    @Max(value = 100)
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
