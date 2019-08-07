package com.stackroute.repository;

import com.stackroute.domain.StandaloneMedia;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StandaloneRepository extends MongoRepository<StandaloneMedia, String> {
}
