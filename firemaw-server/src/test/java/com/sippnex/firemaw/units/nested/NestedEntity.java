package com.sippnex.firemaw.units.nested;

import com.sippnex.firemaw.FiremawProperty;
import com.sippnex.firemaw.FiremawType;

public class NestedEntity {

    @FiremawProperty(name="id", type= FiremawType.NumberField)
    private int id;

    @FiremawProperty(name="name", type= FiremawType.TextField)
    private String name;

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

    public NestedEntity() {

    }

    public NestedEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
