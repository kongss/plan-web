package com.plan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:consumer/plan-service-consumer.xml")
@SpringBootApplication
public class PlanWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlanWebApplication.class, args);
    }

}

