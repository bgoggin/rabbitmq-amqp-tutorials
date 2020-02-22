package org.springframework.amqp.tutorials;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

public class RabbitAmqpTutorialsRunner implements CommandLineRunner {
   private static final Logger LOGGER = LogManager.getLogger(CommandLineRunner.class);
   @Value("${tutorial.client.duration:0}")
   private int duration;

   @Autowired
   private ConfigurableApplicationContext ctx;

   @Override
   public void run(String... arg0) throws Exception {
      LOGGER.info("Ready ... running for {} ms", duration);
      Thread.sleep(duration);
      ctx.close();
   }
}