package hu.helixlab.ms.mainapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"hu.helixlab.ms"})
@EntityScan(basePackages = {"hu.helixlab.ms"})
@ComponentScan(basePackages = {"hu.helixlab.ms"})
@SpringBootApplication
public class MainappApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainappApplication.class, args);
    }

}
