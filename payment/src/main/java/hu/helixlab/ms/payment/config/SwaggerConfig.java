package hu.helixlab.ms.payment.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    //Whether swagger is turned on or not, the formal environment usually needs to be turned off. It can be set according to the multi-environment configuration of spring boot.
    @Value(value = "${swagger.enabled}")
    Boolean swaggerEnabled;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                // Whether to open
                .enable(swaggerEnabled).select()
                // Scanning Path Pack
                .apis(RequestHandlerSelectors.basePackage("hu.helixlab.ms.payment"))
                // Specify a path to process PathSelectors.any() to represent all paths
                .paths(PathSelectors.any()).build().pathMapping("/");
    }


    /**
    Swagger also provides some default values in its response which you can customize, such as “Api Documentation”, “Created by Contact Email”, “Apache 2.0”.
     To change these values, you can use the apiInfo(ApiInfo apiInfo) method. The ApiInfo class that contains custom information about the API.
    * */
    //Setting up api information
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Routing Gateway(Zuul): swagger 2 Payment module service")
                .description("Api description")
                // Author information
                .contact(new Contact("Tivadar Bocz", "https://example.com", "example@gmail.com"))
                .version("1.0.0")
                .build();
    }
}
