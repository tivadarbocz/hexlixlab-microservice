package hu.helixlab.ms.webshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"hu.helixlab.ms.entity"})
@EnableJpaRepositories(basePackages = {"hu.helixlab.ms.dao.repository"})
@ComponentScan(basePackages = {"hu.helixlab.ms"})
@SpringBootApplication
public class WebshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebshopApplication.class, args);
    }

}
