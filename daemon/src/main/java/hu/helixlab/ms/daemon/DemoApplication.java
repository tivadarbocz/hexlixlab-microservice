package hu.helixlab.ms.daemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EntityScan(basePackages = {"hu.helixlab.ms.entity"})
@EnableJpaRepositories(basePackages = {"hu.helixlab.ms.dao.repository"})
@ComponentScan(basePackages = {"hu.helixlab.ms"})
@EnableScheduling
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
