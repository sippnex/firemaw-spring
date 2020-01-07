package com.sippnex.firemaw;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/simple-entity")
public class SimpleEntityController {

    private final FiremawProcessor firemawProcessor;

    public SimpleEntityController(FiremawProcessor firemawProcessor) {
        this.firemawProcessor = firemawProcessor;
    }

    @GetMapping("")
    public FiremawDto getSimpleEntity() {
        SimpleEntity simpleEntity = new SimpleEntity(1L, "Simple Entity 1", "", true, new Date());
        return this.firemawProcessor.serialize(simpleEntity);
    }

}
