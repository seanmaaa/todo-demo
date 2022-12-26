package io.kcdhbp.tododemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TodoDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(TodoDemoApplication.class, args);
  }

}
