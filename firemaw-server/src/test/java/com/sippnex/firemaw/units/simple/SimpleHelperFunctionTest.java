package com.sippnex.firemaw.units.simple;

import com.sippnex.firemaw.FiremawDto;
import com.sippnex.firemaw.FiremawPropertyClass;
import com.sippnex.firemaw.FiremawType;
import org.junit.Assert;
import org.junit.Test;

public class SimpleHelperFunctionTest {

    @Test
    public void run() {

        // 1. Define test values for assertion
        Integer id = 253;
        String name = "SimpleEntity";
        boolean active = true;


        // 2. Create a firemaw dto
        FiremawDto firemawDto = new FiremawDto();
        firemawDto.addProperty(new FiremawPropertyClass("id", FiremawType.NumberField, true, id));
        firemawDto.addProperty(new FiremawPropertyClass("name", FiremawType.TextField, false, name));
        firemawDto.addProperty(new FiremawPropertyClass("active", FiremawType.Checkbox, false, active));

        // 3. Check some property values with dto helper functions
        Assert.assertEquals(id, firemawDto.getProperty("id").getValue());
        Assert.assertEquals(name, firemawDto.getProperty("name").getValue());
        Assert.assertEquals(active, firemawDto.getProperty("active").getValue());
        Assert.assertEquals(id, firemawDto.getPropertyValue("id"));
        Assert.assertEquals(name, firemawDto.getPropertyValue("name"));
        Assert.assertEquals(active, firemawDto.getPropertyValue("active"));

        // 4. Change some values with dto helper function
        firemawDto.setPropertyValue("id", 150);
        firemawDto.setPropertyValue("name", "NewName");
        firemawDto.setPropertyValue("active", false);

        // 5. Check new values
        Assert.assertEquals(150, firemawDto.getProperty("id").getValue());
        Assert.assertEquals("NewName", firemawDto.getProperty("name").getValue());
        Assert.assertEquals(false, firemawDto.getProperty("active").getValue());
        Assert.assertEquals(150, firemawDto.getPropertyValue("id"));
        Assert.assertEquals("NewName", firemawDto.getPropertyValue("name"));
        Assert.assertEquals(false, firemawDto.getPropertyValue("active"));
    }

}
