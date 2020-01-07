package com.sippnex.firemaw.units.polymorphism;

import com.sippnex.firemaw.FiremawProperty;
import com.sippnex.firemaw.FiremawType;

public class SpecializedEntity extends AbstractSuperEntity {

    @FiremawProperty(name="content", type= FiremawType.RichTextField)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SpecializedEntity() {

    }

    public SpecializedEntity(int id, String name, String content) {
        super(id, name);
        this.content = content;
    }
}
