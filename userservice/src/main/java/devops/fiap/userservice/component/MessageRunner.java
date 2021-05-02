package devops.fiap.userservice.component;

import java.util.concurrent.TimeUnit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import devops.fiap.userservice.entity.Message;

@Component
public class MessageRunner {
  
    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

  public MessageRunner(Receiver receiver, RabbitTemplate rabbitTemplate) {
    this.receiver = receiver;
    this.rabbitTemplate = rabbitTemplate;
  }

  public void SentMessage(Message message) {
    System.out.println("Sending message...");
    
    // Set message
    this.receiver.setMessage(message);

    // Convert message and sent to rabbit
    rabbitTemplate.convertAndSend("movies-exchange", "devops.fiap.user", receiver);
    try {
      receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  
}