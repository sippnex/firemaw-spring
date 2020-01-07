package com.sippnex.firemaw;

public class FiremawPropertyClass {

    private String name;

    private FiremawType type;

    public String[] payload;

    private boolean disabled;

    private Object value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FiremawType getType() {
        return type;
    }

    public void setType(FiremawType type) {
        this.type = type;
    }

    public String[] getPayload() {
        return payload;
    }

    public void setPayload(String[] payload) {
        this.payload = payload;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public FiremawPropertyClass() {
        super();
    }

    public FiremawPropertyClass(FiremawProperty firemawProperty, Object value) {
        super();
        this.name = firemawProperty.name();
        this.type = firemawProperty.type();
        this.payload = new String[0];
        this.disabled = firemawProperty.disabled();
        this.value = value;
    }

    public FiremawPropertyClass(FiremawProperty firemawProperty, String[] payload, Object value) {
        super();
        this.name = firemawProperty.name();
        this.type = firemawProperty.type();
        this.payload = payload;
        this.disabled = firemawProperty.disabled();
        this.value = value;
    }

    public FiremawPropertyClass(String name, FiremawType type, boolean disabled, Object value) {
        super();
        this.name = name;
        this.type = type;
        this.payload = new String[0];
        this.disabled = disabled;
        this.value = value;
    }

    public FiremawPropertyClass(String name, FiremawType type, String[] payload, Object value) {
        super();
        this.name = name;
        this.type = type;
        this.payload = payload;
        this.disabled = disabled;
        this.value = value;
    }

    public FiremawPropertyClass(String name, FiremawType type, String[] payload, boolean disabled, Object value) {
        super();
        this.name = name;
        this.type = type;
        this.payload = payload;
        this.disabled = disabled;
        this.value = value;
    }

}
