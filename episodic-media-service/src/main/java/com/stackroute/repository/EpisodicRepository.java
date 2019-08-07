package com.stackroute.repository;

import com.stackroute.domain.EpisodicMedia;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EpisodicRepository extends MongoRepository<EpisodicMedia, String> {
}
