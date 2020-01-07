package com.sippnex.firemaw.units.simple;

import com.sippnex.firemaw.FiremawDto;
import com.sippnex.firemaw.FiremawProcessor;
import com.sippnex.firemaw.FiremawPropertyClass;
import com.sippnex.firemaw.FiremawType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class SimpleDeserializationTest {

    @Test
    public void run() {

        // 1. Define test values for assertion
        Long longId = 253L;
        Integer integerId = 253;
        String name = "SimpleEntity";
        String file = "http://localhost/fileblade/download/testfile.txt";
        SimpleEnum simpleEnum = SimpleEnum.A;
        String simpleEnumString = "A";
        boolean active = true;
        Date date = new Date();

        // 2. Create a fresh firemaw dto with integer id
        FiremawDto firemawDto = new FiremawDto();
        firemawDto.addProperty(new FiremawPropertyClass("id", FiremawType.NumberField, true, integerId));
        firemawDto.addProperty(new FiremawPropertyClass("name", FiremawType.TextField, false, name));
        firemawDto.addProperty(new FiremawPropertyClass("file", FiremawType.FilebladeField, false, file));
        firemawDto.addProperty(new FiremawPropertyClass("simpleEnum", FiremawType.TextField, false, simpleEnumString));
        firemawDto.addProperty(new FiremawPropertyClass("active", FiremawType.Checkbox, false, active));
        firemawDto.addProperty(new FiremawPropertyClass("creationDate", FiremawType.DateField, false, date));

        // 3. Create firemaw processor instance for simple entity
        FiremawProcessor firemawProcessor = new FiremawProcessor();

        // 4. Deserialize firemaw dto to simple entity
        SimpleEntity deserializedSimpleEntity = (SimpleEntity)firemawProcessor.deserialize(firemawDto, SimpleEntity.class);

        // 5. Check simple entity deserialization
        Assert.assertEquals(longId, deserializedSimpleEntity.getId());
        Assert.assertEquals(name, deserializedSimpleEntity.getName());
        Assert.assertEquals(file, deserializedSimpleEntity.getFile());
        Assert.assertEquals(simpleEnum, deserializedSimpleEntity.getSimpleEnum());
        Assert.assertEquals(active, deserializedSimpleEntity.getActive());
        Assert.assertEquals(date, deserializedSimpleEntity.getCreationDate());
    }

}
