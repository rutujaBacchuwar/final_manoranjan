package com.stackroute.config;

import com.stackroute.domain.Episode;
import com.stackroute.domain.EpisodicMedia;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class EpisodicConfig {
    private String address="127.0.0.1:9092";

    //kafka producer factory for episodic media
    @Bean
    public ProducerFactory<EpisodicMedia, EpisodicMedia> producerFactory1() {
        Map<Object, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, address);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory(config);
    }

    //sending episodic media to kafkaTemplate1
    @Bean
    public KafkaTemplate<EpisodicMedia, EpisodicMedia> kafkaTemplate1() {
        return new KafkaTemplate<>(producerFactory1());
    }

    //kafka producer factory for episodes
    @Bean
    public ProducerFactory<Episode, Episode> producerFactory2() {
        Map<Object, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, address);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory(config);
    }

    //sending episodes to kafkatemplate2
    @Bean
    public KafkaTemplate<Episode, Episode> kafkaTemplate2() {
        return new KafkaTemplate<>(producerFactory2());
    }
}
