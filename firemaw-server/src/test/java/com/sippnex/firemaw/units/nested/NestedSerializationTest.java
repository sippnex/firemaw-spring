package com.sippnex.firemaw.units.nested;

import com.sippnex.firemaw.FiremawDto;
import com.sippnex.firemaw.FiremawProcessor;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NestedSerializationTest {

    @Test
    public void run() {

        // 1. Define test values for assertion

        int rootEntityId = 1;
        String rootEntityName = "RootEntityName";

        int nestedEntityId = 2;
        String nestedEntityName = "NestedEntityName";

        int firstNestedEntityListItemId = 3;
        String firstNestedEntityListItemName= "FirstNestedEntityListItemName";

        int secondNestedEntityListItemId = 4;
        String secondNestedEntityListItemName= "SecondNestedEntityListItemName";


        // 2. Create entities with test values

        NestedEntity nestedEntity = new NestedEntity(nestedEntityId, nestedEntityName);

        List<NestedEntity> nestedEntityList = new ArrayList<NestedEntity>();
        nestedEntityList.add(new NestedEntity(firstNestedEntityListItemId, firstNestedEntityListItemName));
        nestedEntityList.add(new NestedEntity(secondNestedEntityListItemId, secondNestedEntityListItemName));

        RootEntity rootEntity = new RootEntity(rootEntityId, rootEntityName, nestedEntity, nestedEntityList);

        // 3. Create firemaw processor instance for root entity
        FiremawProcessor firemawProcessor = new FiremawProcessor();

        // 4. Serialize root entity into firemaw dto
        FiremawDto firemawDto = firemawProcessor.serialize(rootEntity);

        // 5. Check root firemaw dto
        Assert.assertEquals(4, firemawDto.getProperties().size());
        Assert.assertEquals(rootEntityId, firemawDto.getProperties().get(0).getValue());
        Assert.assertEquals(rootEntityName, firemawDto.getProperties().get(1).getValue());

        // 6. Check nested firemaw dto
        FiremawDto nestedFiremawDto = (FiremawDto)firemawDto.getProperties().get(2).getValue();

        Assert.assertEquals(2, nestedFiremawDto.getProperties().size());
        Assert.assertEquals(nestedEntityId, nestedFiremawDto.getProperties().get(0).getValue());
        Assert.assertEquals(nestedEntityName, nestedFiremawDto.getProperties().get(1).getValue());

        // 7. Check nested firemaw dto list
        List<FiremawDto> nestedFiremawDtoList = (List<FiremawDto>)firemawDto.getProperties().get(3).getValue();

        Assert.assertEquals(2, nestedFiremawDtoList.size());
        Assert.assertEquals(firstNestedEntityListItemId, nestedFiremawDtoList.get(0).getProperties().get(0).getValue());
        Assert.assertEquals(firstNestedEntityListItemName, nestedFiremawDtoList.get(0).getProperties().get(1).getValue());
        Assert.assertEquals(secondNestedEntityListItemId, nestedFiremawDtoList.get(1).getProperties().get(0).getValue());
        Assert.assertEquals(secondNestedEntityListItemName, nestedFiremawDtoList.get(1).getProperties().get(1).getValue());
    }

}
