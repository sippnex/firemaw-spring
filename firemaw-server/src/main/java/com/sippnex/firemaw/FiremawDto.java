package com.sippnex.firemaw;

import java.util.ArrayList;
import java.util.List;

public class FiremawDto {

    private List<FiremawPropertyClass> properties;

    public FiremawDto() {
        super();
        this.properties = new ArrayList<FiremawPropertyClass>();
    }

    public List<FiremawPropertyClass> getProperties() {
        return properties;
    }

    public void addProperty(FiremawPropertyClass property) {
        this.properties.add(property);
    }

    public void addProperty(int index, FiremawPropertyClass property) {
        this.properties.add(index, property);
    }

    public void addPropertyRange(List<FiremawPropertyClass> propertyRange) {
        this.properties.addAll(propertyRange);
    }

    public void addPropertyRange(int index, List<FiremawPropertyClass> propertyRange) {
        this.properties.addAll(index, propertyRange);
    }

    public FiremawPropertyClass getProperty(String propertyName) {
        if(this.properties == null || this.properties.size() == 0) { return null; }
        for (FiremawPropertyClass property: this.properties) {
            if(property.getName().equals(propertyName)) {
                return property;
            }
        }
        return null;
    }

    public Object getPropertyValue(String propertyName) {
        return this.getProperty(propertyName).getValue();
    }

    public void setPropertyValue(String propertyName, Object value) {
        FiremawPropertyClass property = this.getProperty(propertyName);
        if(property == null) { return; }
        property.setValue(value);
    }

}
