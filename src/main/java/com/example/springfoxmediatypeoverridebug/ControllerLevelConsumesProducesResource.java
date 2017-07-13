package com.example.springfoxmediatypeoverridebug;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/controller-level", consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
class ControllerLevelConsumesProducesResource {

    @GetMapping(path = "produces", produces="application/octet-stream")
    @ApiOperation(value="Its 'produces' media-types is as expected...")
    public byte[] produces() {
        return new byte[0];
    }

    @PutMapping(path = "consumes", consumes="application/octet-stream")
    @ApiOperation(value="Its 'consumes' media-types is as expected...")
    public void consumes(@RequestBody byte[] data) {
    }

}
