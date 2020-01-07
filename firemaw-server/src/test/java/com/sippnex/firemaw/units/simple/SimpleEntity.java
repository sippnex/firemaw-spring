package com.sippnex.firemaw.units.simple;

import com.sippnex.firemaw.FiremawProperty;
import com.sippnex.firemaw.FiremawType;

import java.util.Date;

public class SimpleEntity {

    @FiremawProperty(name="id", type= FiremawType.NumberField)
    private Long id;

    @FiremawProperty(name="name", type= FiremawType.TextField)
    private String name;

    @FiremawProperty(name="file", type= FiremawType.FilebladeField)
    private String file;

    @FiremawProperty(name="simpleEnum", type= FiremawType.SelectField)
    private SimpleEnum simpleEnum;

    @FiremawProperty(name="active", type= FiremawType.Checkbox)
    private boolean active;

    @FiremawProperty(name="creationDate", type= FiremawType.DateField)
    private Date creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public SimpleEnum getSimpleEnum() {
        return simpleEnum;
    }

    public void setSimpleEnum(SimpleEnum simpleEnum) {
        this.simpleEnum = simpleEnum;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public SimpleEntity() {

    }

    public SimpleEntity(Long id, String name, String file, SimpleEnum simpleEnum, boolean active, Date creationDate) {
        this.id = id;
        this.name = name;
        this.file = file;
        this.simpleEnum = simpleEnum;
        this.active = active;
        this.creationDate = creationDate;
    }
}
