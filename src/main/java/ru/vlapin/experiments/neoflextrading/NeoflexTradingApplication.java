package ru.vlapin.experiments.neoflextrading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
//@EnableHypermediaSupport(type = HAL)
public class NeoflexTradingApplication {

  public static void main(String[] args) {
    SpringApplication.run(NeoflexTradingApplication.class, args);
  }
}
