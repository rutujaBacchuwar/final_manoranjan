package com.stackroute.service;

import com.stackroute.domain.Producer;
import com.stackroute.domain.User;
import com.stackroute.exceptions.*;
import com.stackroute.repository.ProducerRepository;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@CacheConfig(cacheNames = "producer")
@Service
public class ProducerServiceImpl implements ProducerService {

    private ProducerRepository producerRepository;


    @Autowired
    KafkaTemplate<Producer, Producer> kafkaTemplate;

    private static String topic = "saveProducer";

    @Autowired
    public ProducerServiceImpl(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    //to handle delay
    public void simulateDelay(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //save producer
    @CacheEvict(allEntries = true)
    @Override
    public Producer saveProducer(Producer producer) throws ProducerAllReadyExistException {
        if (producerRepository.existsById(producer.getEmailId())) {
            throw new ProducerAllReadyExistException();
        }
        Producer saveProducer = producerRepository.save(producer);
        if (saveProducer == null)
            throw new ProducerAllReadyExistException();

        kafkaTemplate.send(topic, producer);
        return saveProducer;
    }

    //update producer
    @CacheEvict(allEntries = true)
    @Override
    public Producer updateProducer(String emailId, Producer producer) {
        Producer producer1 = new Producer();
        if (producerRepository.existsById(producer.getEmailId())) {
            producer1 = producerRepository.findById(emailId).get();
            producer1.setEmailId(producer.getEmailId());
            producer1.setName(producer.getName());
            producer1.setMobileNo(producer.getMobileNo());
            producer1.setPassword(producer.getPassword());
            producer1.setAge(producer.getAge());
            producer1.setGender(producer.getGender());
            producer1.setUploadedEpisodic(producer.getUploadedEpisodic());
            producer1.setUploadedStandalone(producer.getUploadedStandalone());
            producerRepository.save(producer1);
        }
        return producerRepository.save(producer1);
    }

    //get producer by emailId
    @Cacheable
    @Override
    public Producer getByEmailId(String emailId) {
        Producer producer=new Producer();
        Optional optional = producerRepository.findById(emailId);
        if (optional.isPresent()) {
            producer = producerRepository.findById(emailId).get();
        }
        return producer;
    }

    //get producer by emailId
    @Cacheable
    @Override
    public List<String> getUploadedStandaloneTitle(String emailId) throws ProducerNotFoundException {
        List<String> uploadedStandalone;
        if(producerRepository.existsById(emailId)){
            Producer producer = producerRepository.findById(emailId).get();
            uploadedStandalone=producer.getUploadedStandalone();
            if (uploadedStandalone == null) {
                throw new ProducerNotFoundException();
            }
        }
        else throw new ProducerNotFoundException();
        return uploadedStandalone;
    }

    //get producer by emailId
    @Cacheable
    @Override
    public List<String> getUploadedEpisodicTitle(String emailId) throws ProducerNotFoundException {
        List<String> uploadedEpisodic;
        if(producerRepository.existsById(emailId)){
            Producer producer = producerRepository.findById(emailId).get();
            uploadedEpisodic=producer.getUploadedEpisodic();
            if (uploadedEpisodic == null) {
                throw new ProducerNotFoundException();
            }
        }
        else throw new ProducerNotFoundException();
        return uploadedEpisodic;
    }

    //update uploaded standalone
    @Override
    public List<String> updateUploadedStandalone(String emailId, String uploadedStandalone) throws ProducerNotFoundException, DataAlreadyExistException {
        Producer producer;
        List<String> upStandalone;
        if(producerRepository.existsById(emailId)){
            producer=producerRepository.findById(emailId).get();
            if(producer.getUploadedStandalone().contains(uploadedStandalone)){
                throw new DataAlreadyExistException();
            }
            upStandalone=producer.getUploadedStandalone();
            upStandalone.add(uploadedStandalone);
            producer.setUploadedStandalone(upStandalone);
            producerRepository.save(producer);
        }
        else throw new ProducerNotFoundException();
        return upStandalone;
    }

    @Override
    public List<String> updateUploadedEpisodic(String emailId, String uploadedEpisodic)throws ProducerNotFoundException,DataAlreadyExistException {
        Producer producer;
        List<String> upEpisodic;
        if(producerRepository.existsById(emailId)){
            producer=producerRepository.findById(emailId).get();
            if(producer.getUploadedEpisodic().contains(uploadedEpisodic)){
                throw new DataAlreadyExistException();
            }
            upEpisodic=producer.getUploadedStandalone();
            upEpisodic.add(uploadedEpisodic);
            producer.setUploadedStandalone(upEpisodic);
            producerRepository.save(producer);
        }
        else throw new ProducerNotFoundException();
        return upEpisodic;
    }

}
