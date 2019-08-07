package com.stackroute.seed;

import com.stackroute.domain.Producer;
import com.stackroute.domain.User;
import com.stackroute.repository.ProducerRepository;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource("classpath:config.properties")
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    Producer producer= new Producer();
    Producer producer1 = new Producer();
    Producer producer2 = new Producer();
    @Autowired
    ProducerRepository producerRepository;
    @Autowired
    private Environment environment;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        producer.setEmailId(environment.getProperty("producer.emailId"));
        producer.setName(environment.getProperty("producer.name"));
        producer.setAge(Integer.parseInt(environment.getProperty("producer.age")));
        producer.setGender(environment.getProperty("producer.gender"));
        producer.setMobileNo(environment.getProperty("producer.mobileNo"));
        producer.setPassword(environment.getProperty("producer.password"));
        List <String> standalone=new ArrayList<>();
        standalone.add(environment.getProperty("producer.uploadedStandalone"));
        producer.setUploadedStandalone(standalone);
        List <String> episodic=new ArrayList<>();
        episodic.add(environment.getProperty("producer.uploadedEpisodic"));
        producer.setUploadedEpisodic(episodic);
        producer.setRole(environment.getProperty("producer.role"));
        producerRepository.save(producer);

        producer1.setEmailId(environment.getProperty("producer1.emailId"));
        producer1.setName(environment.getProperty("producer1.name"));
        producer1.setAge(Integer.parseInt(environment.getProperty("producer1.age")));
        producer1.setGender(environment.getProperty("producer1.gender"));
        producer1.setMobileNo(environment.getProperty("producer1.mobileNo"));
        producer1.setPassword(environment.getProperty("producer1.password"));
        List <String> standalone1=new ArrayList<>();
        standalone1.add(environment.getProperty("producer1.uploadedStandalone"));
        producer1.setUploadedStandalone(standalone1);
        List <String> episodic1=new ArrayList<>();
        episodic1.add(environment.getProperty("producer1.uploadedEpisodic"));
        producer1.setUploadedEpisodic(episodic1);
        producer1.setRole(environment.getProperty("producer1.role"));
        producerRepository.save(producer1);

        producer2.setEmailId(environment.getProperty("producer2.emailId"));
        producer2.setName(environment.getProperty("producer2.name"));
        producer2.setAge(Integer.parseInt(environment.getProperty("producer2.age")));
        producer2.setGender(environment.getProperty("producer2.gender"));
        producer2.setMobileNo(environment.getProperty("producer2.mobileNo"));
        producer2.setPassword(environment.getProperty("producer2.password"));
        List <String> standalone2=new ArrayList<>();
        standalone2.add(environment.getProperty("producer2.uploadedStandalone"));
        producer2.setUploadedStandalone(standalone2);
        List <String> episodic2=new ArrayList<>();
        episodic2.add(environment.getProperty("producer2.uploadedEpisodic"));
        producer2.setUploadedEpisodic(episodic2);
        producer2.setRole(environment.getProperty("producer2.role"));
        producerRepository.save(producer2);
    }
}
