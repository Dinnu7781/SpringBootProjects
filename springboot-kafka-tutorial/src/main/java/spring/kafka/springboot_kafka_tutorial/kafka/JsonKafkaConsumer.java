package spring.kafka.springboot_kafka_tutorial.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import spring.kafka.springboot_kafka_tutorial.payload.User;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "Basic_Json", groupId = "myGroup")
    public void consume(User user){
        LOGGER.info(String.format("Message received from User %s",user.toString()));
    }
}
