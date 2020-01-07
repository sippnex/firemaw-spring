package com.sippnex.firemaw.units.nested;

import com.sippnex.firemaw.FiremawDto;
import com.sippnex.firemaw.FiremawProcessor;
import com.sippnex.firemaw.FiremawPropertyClass;
import com.sippnex.firemaw.FiremawType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NestedDeserializationTest {

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


        // 2. Create firemaw dtos with test values

        FiremawDto nestedFiremawDto = new FiremawDto();
        nestedFiremawDto.addProperty(new FiremawPropertyClass("id", FiremawType.NumberField, true, nestedEntityId));
        nestedFiremawDto.addProperty(new FiremawPropertyClass("name", FiremawType.TextField, false, nestedEntityName));

        FiremawDto firstNestedFiremawDtoListItem = new FiremawDto();
        firstNestedFiremawDtoListItem.addProperty(new FiremawPropertyClass("id", FiremawType.NumberField, true, firstNestedEntityListItemId));
        firstNestedFiremawDtoListItem.addProperty(new FiremawPropertyClass("name", FiremawType.TextField, false, firstNestedEntityListItemName));

        FiremawDto secondNestedFiremawDtoListItem = new FiremawDto();
        secondNestedFiremawDtoListItem.addProperty(new FiremawPropertyClass("id", FiremawType.NumberField, true, secondNestedEntityListItemId));
        secondNestedFiremawDtoListItem.addProperty(new FiremawPropertyClass("name", FiremawType.TextField, false, secondNestedEntityListItemName));

        List<FiremawDto> nestedFiremawDtoList = new ArrayList<FiremawDto>();
        nestedFiremawDtoList.add(firstNestedFiremawDtoListItem);
        nestedFiremawDtoList.add(secondNestedFiremawDtoListItem);

        FiremawDto rootFiremawDto = new FiremawDto();
        rootFiremawDto.addProperty(new FiremawPropertyClass("id", FiremawType.NumberField, true, rootEntityId));
        rootFiremawDto.addProperty(new FiremawPropertyClass("name", FiremawType.TextField, false, rootEntityName));
        rootFiremawDto.addProperty(new FiremawPropertyClass("nestedEntity", FiremawType.SubEntity, false, nestedFiremawDto));
        rootFiremawDto.addProperty(new FiremawPropertyClass("nestedEntityList", FiremawType.SubEntityList, false, nestedFiremawDtoList));

        // 3. Create firemaw processor instance
        FiremawProcessor firemawProcessor = new FiremawProcessor();

        // 3. Deserialize firemaw dto to root entity
        RootEntity deserializedRootEntity = (RootEntity) firemawProcessor.deserialize(rootFiremawDto, RootEntity.class);

        // 4. Check root entity deserialization
        Assert.assertEquals(rootEntityId, deserializedRootEntity.getId());
        Assert.assertEquals(rootEntityName, deserializedRootEntity.getName());
        Assert.assertNotNull(deserializedRootEntity.getNestedEntity());
        Assert.assertEquals(nestedEntityId, deserializedRootEntity.getNestedEntity().getId());
        Assert.assertEquals(nestedEntityName, deserializedRootEntity.getNestedEntity().getName());
        Assert.assertNotNull(deserializedRootEntity.getNestedEntityList());
        Assert.assertEquals(2, deserializedRootEntity.getNestedEntityList().size());
        Assert.assertEquals(firstNestedEntityListItemId, deserializedRootEntity.getNestedEntityList().get(0).getId());
        Assert.assertEquals(firstNestedEntityListItemName, deserializedRootEntity.getNestedEntityList().get(0).getName());
        Assert.assertEquals(secondNestedEntityListItemId, deserializedRootEntity.getNestedEntityList().get(1).getId());
        Assert.assertEquals(secondNestedEntityListItemName, deserializedRootEntity.getNestedEntityList().get(1).getName());
    }

}
