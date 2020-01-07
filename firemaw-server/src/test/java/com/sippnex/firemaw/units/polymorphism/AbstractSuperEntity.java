package com.sippnex.firemaw.units.polymorphism;

import com.sippnex.firemaw.FiremawProperty;
import com.sippnex.firemaw.FiremawType;

public abstract class AbstractSuperEntity {

    @FiremawProperty(name="id", type= FiremawType.NumberField, disabled = true)
    private int id;

    @FiremawProperty(name="name", type= FiremawType.TextField)
    private String name;

    private String ignore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIgnore() {
        return ignore;
    }

    public void setIgnore(String ignore) {
        this.ignore = ignore;
    }

    public AbstractSuperEntity() {

    }

    public AbstractSuperEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
