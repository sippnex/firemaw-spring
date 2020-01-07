package com.sippnex.firemaw;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FiremawProcessor implements IFiremawProcessor {

    public FiremawDto serialize(Object object) {

        try {

            FiremawDto firemawEntity = new FiremawDto();

            // Process class field annotations, including all super classes
            Class currentClass = object.getClass();
            do {
                List<FiremawPropertyClass> currentPropertyList = new ArrayList<FiremawPropertyClass>();
                for(Field field: currentClass.getDeclaredFields()) {
                    FiremawPropertyClass property = this.serializeField(object, field);
                    if(property != null) {
                        currentPropertyList.add(property);
                    }
                }
                firemawEntity.addPropertyRange(0, currentPropertyList);
                currentClass = currentClass.getSuperclass();
            } while(currentClass != null);

            return firemawEntity;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }


    public Object deserialize(FiremawDto firemawDto, Class clazz) {

        try {

            Object object = clazz.newInstance();
            List<FiremawPropertyClass> firemawPropertyClasses = firemawDto.getProperties();

            // Process class field annotations, including all super classes
            Class currentClass = clazz;
            do {
                List<FiremawPropertyClass> currentPropertyList = new ArrayList<FiremawPropertyClass>();
                for(Field field: currentClass.getDeclaredFields()) {
                    Object value = this.deserializeField(firemawDto, field);
                    if(value != null) {
                        field.set(object, value);
                    }
                }
                currentClass = currentClass.getSuperclass();
            } while(currentClass != null);

            return object;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    private FiremawPropertyClass serializeField(Object object, Field field) throws Exception {

        field.setAccessible(true);
        FiremawProperty firemawProperty = field.getAnnotation(FiremawProperty.class);

        if(firemawProperty != null) {

            if(firemawProperty.type() == FiremawType.SubEntity) {

                Class clazz = field.get(object).getClass();
                FiremawDto firemawDto = this.serialize(field.get(object));
                return new FiremawPropertyClass(firemawProperty, firemawDto);

            } else if(firemawProperty.type() == FiremawType.SubEntityList) {

                List<Object> subEntityList = (List<Object>)field.get(object);
                List<FiremawDto> firemawDtoList = new ArrayList<FiremawDto>();
                for(int i=0; i<subEntityList.size(); i++) {
                    Class clazz = subEntityList.get(i).getClass();
                    firemawDtoList.add(this.serialize(subEntityList.get(i)));
                }
                return new FiremawPropertyClass(firemawProperty, firemawDtoList);

            } else if(firemawProperty.type() == FiremawType.SelectField) {

                Class clazz = field.getType();
                Field enumValues = clazz.getDeclaredField("$VALUES");
                enumValues.setAccessible(true);
                Object o = enumValues.get(null);
                Enum[] enumPayload = (Enum[]) o;
                String[] payload = new String[enumPayload.length];
                for(int i=0; i<enumPayload.length; i++) {
                    payload[i] = enumPayload[i].toString();
                }
                return new FiremawPropertyClass(firemawProperty, payload, field.get(object));

            } else {

                return new FiremawPropertyClass(firemawProperty, field.get(object));
            }

        }

        return null;
    }

    private Object deserializeField(FiremawDto firemawDto, Field field) throws Exception {

        for(FiremawPropertyClass firemawPropertyClass:  firemawDto.getProperties()) {

            field.setAccessible(true);
            FiremawProperty firemawProperty = field.getAnnotation(FiremawProperty.class);

            if(firemawProperty != null && firemawProperty.name().equals(firemawPropertyClass.getName())) {

                if(firemawProperty.type() == FiremawType.SubEntity) {

                    Class clazz = field.getType();
                    return this.deserialize((FiremawDto)firemawPropertyClass.getValue(), clazz);

                } else if(firemawProperty.type() == FiremawType.SubEntityList) {

                    List<FiremawDto> firemawDtoList = (List<FiremawDto>)firemawPropertyClass.getValue();
                    List<Object> subEntityList = new ArrayList<Object>();
                    for(int i=0; i<firemawDtoList.size(); i++) {
                        Type type = field.getGenericType();
                        ParameterizedType parameterizedType = (ParameterizedType) type;
                        Type[] typeArguments = parameterizedType.getActualTypeArguments();
                        Class clazz = (Class) typeArguments[0];
                        subEntityList.add(this.deserialize(firemawDtoList.get(i), clazz));
                    }
                    return subEntityList;

                } else if(firemawProperty.type() == FiremawType.SelectField  && firemawPropertyClass.getValue() instanceof String) {

                    Class clazz = field.getType();
                    return (Object)Enum.valueOf((Class<? extends Enum>) clazz, (String)firemawPropertyClass.getValue());

                } else if(firemawProperty.type() == FiremawType.NumberField) {

                    Class clazz = field.getType();
                    if(field.getType() == Long.class && firemawPropertyClass.getValue() instanceof Integer) {
                        return new Long((Integer)firemawPropertyClass.getValue());
                    } else {
                        return firemawPropertyClass.getValue();
                    }

                } else {

                    return firemawPropertyClass.getValue();

                }
            }
        }
        return null;
    }

}
