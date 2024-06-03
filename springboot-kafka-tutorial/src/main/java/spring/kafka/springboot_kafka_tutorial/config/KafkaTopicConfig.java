package spring.kafka.springboot_kafka_tutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    String topicName;

    @Bean
    public NewTopic jasTopic(){
        return TopicBuilder.name(topicName)
                .build();
    }

    @Bean
    public NewTopic jasJsonTopic(){
        return TopicBuilder.name("Basic_Json")
                .build();
    }
}
