package org.hibernate.validator.referenceguide.chapter02.containerelement.map;

import javax.validation.constraints.NotNull;
import java.util.HashMap;

public class Car {
    public enum FuelConsumption {
        CITY,
        HIGHWAY
    }
//    private Map<@NotNull FuelConsumption, @MaxAllowedFuelConsumption Integer> fuelConsumption = new HashMap<>();
//
//    public void setFuelConsumption(FuelConsumption consumption, int value) {
//        fuelConsumption.put( consumption, value );
//    }
}
