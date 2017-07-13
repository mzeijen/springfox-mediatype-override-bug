package com.example.springfoxmediatypeoverridebug;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/docket-level")
class DocketLevelConsumesProducesResource {

    @GetMapping(path = "produces", produces="application/octet-stream")
    @ApiOperation(value="Its produces media-types aren't as expected...")
    public byte[] produces() {
        return new byte[0];
    }

    @PutMapping(path = "consumes", consumes="application/octet-stream")
    @ApiOperation(value="Its consumes media-types aren't as expected...")
    public void consumes(@RequestBody byte[] data) {
    }
}
