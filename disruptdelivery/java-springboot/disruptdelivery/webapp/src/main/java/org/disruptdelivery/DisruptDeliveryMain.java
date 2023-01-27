package org.disruptdelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 * */
@SpringBootApplication
@ComponentScan("org.disruptdelivery.base")
@EnableJpaRepositories("org.disruptdelivery.base.repository")
@EntityScan("org.disruptdelivery.base.domain")
public class DisruptDeliveryMain
{
    public static void main( String[] args ){
        SpringApplication.run(DisruptDeliveryMain.class, args);
    }
}
