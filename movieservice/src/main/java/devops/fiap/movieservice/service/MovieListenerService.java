package devops.fiap.movieservice.service;

import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

import devops.fiap.movieservice.component.Receiver;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;

@Service
@EnableBinding(Sink.class)
public class MovieListenerService {
    static final String topicExchangeName = "movies-exchange";
    static final String queueName = "movies";

    @Bean 
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
      return new TopicExchange(topicExchangeName);
    }
  
    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
      return BindingBuilder.bind(queue).to(exchange).with("fiap.movieservice.service");
    }

    @Bean 
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, 
        MessageListenerAdapter listenerAdapter) {
            SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();

            container.setConnectionFactory(connectionFactory);
            container.setQueueNames(queueName);
            container.setMessageListener(listenerAdapter);

            return container;
        }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver,   "receiveMessage");
    }
}

