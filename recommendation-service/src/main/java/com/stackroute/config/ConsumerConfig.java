package com.stackroute.config;

import com.stackroute.domain.EpisodicMedia;
import com.stackroute.domain.StandaloneMedia;
import com.stackroute.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class ConsumerConfig {
    @Bean
    public ConsumerFactory<EpisodicMedia,EpisodicMedia> consumerFactory()
    {
        Map<String,Object> config=new HashMap<>();
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG,"Group_EpisodicMediaObject");
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(config,new JsonDeserializer<EpisodicMedia>(),new JsonDeserializer<EpisodicMedia>(EpisodicMedia.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<EpisodicMedia,EpisodicMedia> kafkaListenerContainerFactory()
    {
        ConcurrentKafkaListenerContainerFactory<EpisodicMedia,EpisodicMedia> factory=new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<StandaloneMedia,StandaloneMedia> consumerFactory1()
    {
        Map<String,Object> config=new HashMap<>();
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG,"Group_MediaObject");
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(config,new JsonDeserializer<StandaloneMedia>(),new JsonDeserializer<StandaloneMedia>(StandaloneMedia.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<StandaloneMedia,StandaloneMedia> kafkaListenerContainerFactory1()
    {
        ConcurrentKafkaListenerContainerFactory<StandaloneMedia,StandaloneMedia> factory=new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory1());
        return factory;
    }

    @Bean
    public ConsumerFactory<User, User> consumerFactory2()
    {
        Map<String,Object> config=new HashMap<>();
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG,"Group_MediaObject");
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(config,new JsonDeserializer<User>(),new JsonDeserializer<User>(User.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<User,User> kafkaListenerContainerFactory2()
    {
        ConcurrentKafkaListenerContainerFactory<User,User> factory=new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory2());
        return factory;
    }
}
