package hu.helixlab.ms.zuul.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@Api(tags="zuul inside rest api")
public class DemoController {

	@GetMapping("/hello")
	@ApiOperation(value="demo Example",notes="demo Example")
	@ApiImplicitParam(name="name",value="Name",example="oKong")
	public String hello(String name) {
		return "hi," + name + ",this is zuul api! ";
	}
}