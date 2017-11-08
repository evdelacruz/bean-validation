package com.evdelacruz.samples.beanvalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.evdelacruz.samples.beanvalidation.configuration")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
