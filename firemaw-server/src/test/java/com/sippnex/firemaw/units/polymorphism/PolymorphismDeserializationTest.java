package com.sippnex.firemaw.units.polymorphism;

import com.sippnex.firemaw.FiremawDto;
import com.sippnex.firemaw.FiremawProcessor;
import com.sippnex.firemaw.FiremawPropertyClass;
import com.sippnex.firemaw.FiremawType;
import org.junit.Assert;
import org.junit.Test;

public class PolymorphismDeserializationTest {

    @Test
    public void run() {

        // 1. Define test values for assertion
        int id = 1;
        String name = "SpecializedEntity";
        String content = "Test Content";

        // 2. Create a fresh firemaw dto
        FiremawDto firemawDto = new FiremawDto();
        firemawDto.addProperty(new FiremawPropertyClass("id", FiremawType.NumberField, true, id));
        firemawDto.addProperty(new FiremawPropertyClass("name", FiremawType.TextField, false, name));
        firemawDto.addProperty(new FiremawPropertyClass("content", FiremawType.RichTextField, false, content));

        // 3. Create firemaw processor instance
        FiremawProcessor firemawProcessor = new FiremawProcessor();

        // 6. Deserialize firemaw dto to specialized entity
        SpecializedEntity deserializedSpecializedEntity = (SpecializedEntity) firemawProcessor.deserialize(firemawDto, SpecializedEntity.class);

        // 7. Check specialized entity deserialization
        Assert.assertEquals(id, deserializedSpecializedEntity.getId());
        Assert.assertEquals(name, deserializedSpecializedEntity.getName());
        Assert.assertEquals(content, deserializedSpecializedEntity.getContent());
    }

}
