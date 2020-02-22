package org.springframework.amqp.tutorials;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class RabbitAmqpTutorialsApplication {
   private static final Logger LOGGER = LogManager.getLogger(RabbitAmqpTutorialsApplication.class);
   @Profile("usage_message")
   @Bean
   public CommandLineRunner usage() {
      return args -> {
         LOGGER.info("This app uses Spring Profiles to control its behavior.\n");
               LOGGER.info("Sample usage: java -jar {} --spring.profiles.active=hello-world,sender", this.getClass().getName());
      };
   }

   @Profile("!usage_message")
   @Bean
   public CommandLineRunner tutorial() {
      return new RabbitAmqpTutorialsRunner();
   }

   public static void main(String[] args) throws Exception {
      SpringApplication.run(RabbitAmqpTutorialsApplication.class, args);
   }
}