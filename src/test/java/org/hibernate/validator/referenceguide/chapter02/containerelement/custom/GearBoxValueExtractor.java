package org.hibernate.validator.referenceguide.chapter02.containerelement.custom;

import javax.validation.valueextraction.ExtractedValue;
import javax.validation.valueextraction.ValueExtractor;

public class GearBoxValueExtractor implements ValueExtractor<GearBox<@ExtractedValue ?>> {
    @Override
    public void extractValues(GearBox<@ExtractedValue ?> originalValue, ValueReceiver receiver) {
        receiver.value(null,originalValue.getGear());
    }
}
