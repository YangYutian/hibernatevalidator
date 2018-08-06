package org.hibernate.validator.referenceguide.chapter02.containerelement.set;

import java.util.HashSet;
import java.util.Set;

public class Car {
    private Set<@ValidPart String> parts = new HashSet<>();

    public void addPart(String part) {
        parts.add( part );
    }

//    public Set<String> getParts() {
//        return parts;
//    }
//
//    public void setParts(Set<String> parts) {
//        this.parts = parts;
//    }
}
