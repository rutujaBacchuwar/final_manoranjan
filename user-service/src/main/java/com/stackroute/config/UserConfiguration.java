package com.stackroute.config;

import com.stackroute.domain.Producer;
import com.stackroute.domain.User;
import com.stackroute.domain.UserPayment;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class UserConfiguration {

    //kafka producer factory configuration for user
    @Bean
    public ProducerFactory<User, User> producerFactory() {
        Map<Object, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory(config);

    }

    //kafka template for storing user details
    @Bean
    public KafkaTemplate<User, User> kafkaTemplate()
    {
        return new KafkaTemplate<>(producerFactory());
    }

    //kafka producer factory configuration for user
    @Bean
    public ProducerFactory<Producer, Producer> producerFactory1() {
        Map<Object, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory(config);

    }

    //kafka template for storing user details
    @Bean
    public KafkaTemplate<Producer, Producer> kafkaTemplate1()
    {
        return new KafkaTemplate<>(producerFactory1());
    }

    //consumer factory for user payment
    @Bean
    public ConsumerFactory<UserPayment, UserPayment> consumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "Group_JsonObject");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config,new JsonDeserializer<UserPayment>(),new JsonDeserializer<UserPayment>(UserPayment.class));

    }

    //consurrent kafka listener factory for consuming user payment details from kafka
    @Bean
    public ConcurrentKafkaListenerContainerFactory<UserPayment, UserPayment> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<UserPayment, UserPayment> factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
