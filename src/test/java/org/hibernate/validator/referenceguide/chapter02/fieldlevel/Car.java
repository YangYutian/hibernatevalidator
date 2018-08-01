package org.hibernate.validator.referenceguide.chapter02.fieldlevel;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

public class Car {
    @NotNull
    private String manufacturer;
    @AssertTrue
    private boolean isRegistered;

    public Car(@NotNull String manufacturer, @AssertTrue boolean isRegistered) {
        this.manufacturer = manufacturer;
        this.isRegistered = isRegistered;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }
}
