package com.stackroute.repository;

import com.stackroute.domain.Producer;
import com.stackroute.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends MongoRepository<Producer, String> {
}
