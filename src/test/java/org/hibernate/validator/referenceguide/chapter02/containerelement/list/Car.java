package org.hibernate.validator.referenceguide.chapter02.containerelement.list;

import org.hibernate.validator.referenceguide.chapter02.containerelement.set.ValidPart;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private List<@ValidPart String> parts = new ArrayList<>();
    public void addPart(String part) {
        parts.add( part );
    }
}
