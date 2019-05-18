package hu.helixlab.ms.payment.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags="payment module - Ping Controller")
@RestController
public class PingRestController {

    @ApiOperation(value="Ping operation")
    @GetMapping("ping")
    public String ping() {
        return "I'm alive!";
    }

    @ApiOperation(value="Ping operation")
    @GetMapping("ping/{name}")
    public String sayMyName(@ApiParam("The name, what we want to say") @PathVariable("name") String name) {

        return name + "! I'm alive!";
    }
}
