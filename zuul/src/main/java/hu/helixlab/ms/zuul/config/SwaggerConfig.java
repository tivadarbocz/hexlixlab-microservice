package hu.helixlab.ms.zuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Component
@EnableSwagger2
@Configuration
@Primary //This class is preferred when there are multiple bean s
public class SwaggerConfig implements SwaggerResourcesProvider {

    //Whether swagger is turned on or not, the formal environment usually needs to be turned off. It can be set according to the multi-environment configuration of spring boot.
    @Value(value = "${swagger.enabled}")
    Boolean swaggerEnabled;

    @Autowired
    RouteLocator routeLocator;


    @Override
    public List get() {
        List resources = new ArrayList<>();
        resources.add(swaggerResource("payment-service", "/payment/v2/api-docs", "2.0"));
        resources.add(swaggerResource("webshop-service", "/webshop/v2/api-docs", "2.0"));

        return resources;
    }

    //Setting up api information
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Routing Gateway(Zuul): utilize swagger2 polymerization API File")
                .description("API description")
                // Author information
                .contact(new Contact("Tivadar Bocz", "https://example.com", "example@gmail.com"))
                .version("1.0.0")
                .termsOfServiceUrl("https://ww.example.com")
                .build();
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}