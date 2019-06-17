package com.chanyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.chanyi"})
public class StartBoot {

  public static void main(String[] args) {
    SpringApplication.run(StartBoot.class, args);
  }
}
