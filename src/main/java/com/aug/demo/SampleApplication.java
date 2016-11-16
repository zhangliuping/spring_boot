package com.aug.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
        // SpringApplication.run(SampleApplication.class, new String[] {
        // "hello", "evan" });
    }
}
