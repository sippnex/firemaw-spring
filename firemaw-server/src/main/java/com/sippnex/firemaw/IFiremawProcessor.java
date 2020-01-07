package com.sippnex.firemaw;

public interface IFiremawProcessor {

    public FiremawDto serialize(Object object);

    public Object deserialize(FiremawDto firemawDto, Class clazz);

}
