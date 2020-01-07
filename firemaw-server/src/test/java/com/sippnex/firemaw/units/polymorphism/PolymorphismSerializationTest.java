package com.sippnex.firemaw.units.polymorphism;

import com.sippnex.firemaw.FiremawDto;
import com.sippnex.firemaw.FiremawProcessor;
import org.junit.Assert;
import org.junit.Test;

public class PolymorphismSerializationTest {

    @Test
    public void run() {

        // 1. Define test values for assertion
        int id = 1;
        String name = "SpecializedEntity";
        String content = "Test Content";

        // 2. Create specialized entity with test values
        SpecializedEntity specializedEntity = new SpecializedEntity(id, name, content);

        // 3. Create firemaw processor instance for simple entity
        FiremawProcessor firemawProcessor = new FiremawProcessor();

        // 4. Serialize specialized entity into firemaw dto
        FiremawDto firemawDto = firemawProcessor.serialize(specializedEntity);

        // 5. Check firemaw dto
        Assert.assertEquals(3, firemawDto.getProperties().size());
        Assert.assertEquals(id, firemawDto.getProperties().get(0).getValue());
        Assert.assertEquals(name, firemawDto.getProperties().get(1).getValue());
        Assert.assertEquals(content, firemawDto.getProperties().get(2).getValue());
    }

}
