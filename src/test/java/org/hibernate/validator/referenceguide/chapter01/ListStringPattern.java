package org.hibernate.validator.referenceguide.chapter01;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ListStringPatternValidator.class)
@Documented
public @interface ListStringPattern {
    String message() default "List<String>中的String不符合指定的正则表达式";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String regexp();

    /**
     * Defines several {@link ListStringPattern} annotations on the same element.
     *
     * @see ListStringPattern
     */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {

        ListStringPattern[] value();
    }
}
