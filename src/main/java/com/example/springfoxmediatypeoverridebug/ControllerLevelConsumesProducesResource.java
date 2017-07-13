package com.example.springfoxmediatypeoverridebug;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/controller-level", consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
class ControllerLevelConsumesProducesResource {

    @GetMapping(path = "produces", produces="text/plain")
    @ApiOperation(value="Its 'produces' media-types is as expected...")
    public String produces() {
        return "Hello SpringFox :D";
    }

    @PutMapping(path = "consumes", consumes="text/plain")
    @ApiOperation(value="Its 'consumes' media-types is as expected...")
    public void consumes(@RequestBody String data) {
    }

}
