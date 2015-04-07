package com.bbva.zic.routine.commons.rm.utils.mappers;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Mapper {

    /**
     * The value may indicate a suggestion for a logical component name, to be turned into a Spring bean in case of an
     * autodetected component.
     *
     * @return the suggested component name, if any
     */
    String value() default "";
}
