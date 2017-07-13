package com.example.springfoxmediatypeoverridebug;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/docket-level")
class DocketLevelConsumesProducesResource {

    @GetMapping(path = "produces", produces="text/plain")
    @ApiOperation(value="Its produces media-types aren't as expected...")
    public String produces() {
        return "Hello Springfox :D";
    }

    @PutMapping(path = "consumes", consumes="text/plain")
    @ApiOperation(value="Its consumes media-types aren't as expected...")
    public void consumes(@RequestBody String data) {
    }
}
