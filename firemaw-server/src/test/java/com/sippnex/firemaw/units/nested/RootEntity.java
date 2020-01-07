package com.sippnex.firemaw.units.nested;

import com.sippnex.firemaw.FiremawProperty;
import com.sippnex.firemaw.FiremawType;

import java.util.List;

public class RootEntity {

    @FiremawProperty(name="id", type= FiremawType.NumberField)
    private int id;

    @FiremawProperty(name="name", type= FiremawType.TextField)
    private String name;

    @FiremawProperty(name="nestedEntity", type= FiremawType.SubEntity)
    private NestedEntity nestedEntity;

    @FiremawProperty(name="nestedEntityList", type= FiremawType.SubEntityList)
    private List<NestedEntity> nestedEntityList;

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

    public NestedEntity getNestedEntity() {
        return nestedEntity;
    }

    public void setNestedEntity(NestedEntity nestedEntity) {
        this.nestedEntity = nestedEntity;
    }

    public List<NestedEntity> getNestedEntityList() {
        return nestedEntityList;
    }

    public void setNestedEntityList(List<NestedEntity> nestedEntityList) {
        this.nestedEntityList = nestedEntityList;
    }

    public RootEntity() {

    }

    public RootEntity(int id, String name, NestedEntity nestedEntity, List<NestedEntity> nestedEntityList) {
        this.id = id;
        this.name = name;
        this.nestedEntity = nestedEntity;
        this.nestedEntityList = nestedEntityList;
    }
}
