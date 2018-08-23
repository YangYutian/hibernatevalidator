package org.hibernate.validator.referenceguide.chapter02.containerelement.set;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidPartValidator.class)
@Documented
public @interface ValidPart {

    String message() default "{org.hibernate.validator.referenceguide.chapter02.containerelement.set.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

//    String value();

    @Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List{
        ValidPart[] value();
    }

}
