package org.springframework.amqp.tutorials.tut1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;


@RabbitListener(queues = "hello")
public class Tut1Receiver {
   private static final Logger LOGGER = LogManager.getLogger(Tut1Receiver.class);
   @RabbitHandler
   public void receive(String in) {
      LOGGER.info(" [x] Received '{}'", in);
   }
}