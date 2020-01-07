package com.sippnex.firemaw;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FiremawProperty {

    public String name();

    public FiremawType type();

    public boolean disabled() default false;

}
