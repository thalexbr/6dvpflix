package devops.fiap.movieservice.component;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

import devops.fiap.movieservice.entity.Message;

@Component
public class Receiver {
    private CountDownLatch latch = new CountDownLatch(1);
    private Message message;

    // Setter
    public void setMessage(Message message){
      this.message = message;
    }

    public void receiveMessage() {
      System.out.println("Received <" + this.message + ">");
      latch.countDown();
    }
  
    public CountDownLatch getLatch() {
      return latch;
    }
}
