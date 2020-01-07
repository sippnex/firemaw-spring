package com.sippnex.firemaw.units.simple;

import com.sippnex.firemaw.FiremawDto;
import com.sippnex.firemaw.FiremawProcessor;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class SimpleSerializationTest {

    @Test
    public void run() {

        // 1. Define test values for assertion
        Long id = 1L;
        String name = "SimpleEntity";
        String file = "http://localhost/fileblade/download/testfile.txt";
        SimpleEnum simpleEnum = SimpleEnum.A;
        boolean active = true;
        Date date = new Date();

        // 2. Create simple entity with test values
        SimpleEntity simpleEntity = new SimpleEntity(id, name, file, simpleEnum, active, date);

        // 3. Create firemaw processor instance for simple entity
        FiremawProcessor firemawProcessor = new FiremawProcessor();

        // 4. Serialize simple entity into firemaw dto
        FiremawDto firemawDto = firemawProcessor.serialize(simpleEntity);

        // 5. Check firemaw dto
        Assert.assertEquals(6, firemawDto.getProperties().size());
        Assert.assertEquals(id, firemawDto.getProperties().get(0).getValue());
        Assert.assertEquals(name, firemawDto.getProperties().get(1).getValue());
        Assert.assertEquals(file, firemawDto.getProperties().get(2).getValue());
        Assert.assertEquals(simpleEnum, firemawDto.getProperties().get(3).getValue());
        Assert.assertEquals(3, firemawDto.getProperties().get(3).getPayload().length);
        Assert.assertEquals(active, firemawDto.getProperties().get(4).getValue());
        Assert.assertEquals(date, firemawDto.getProperties().get(5).getValue());
    }

}
