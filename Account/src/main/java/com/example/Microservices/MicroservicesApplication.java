package com.example.Microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
// this is accounts Microsservice

public class MicroservicesApplication {

  public static void main(String[] args) {
    SpringApplication.run(MicroservicesApplication.class, args);
  }

}
