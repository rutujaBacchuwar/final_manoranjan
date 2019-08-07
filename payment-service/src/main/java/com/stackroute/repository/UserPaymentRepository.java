package com.stackroute.repository;

import com.stackroute.domain.UserPayment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserPaymentRepository extends MongoRepository<UserPayment, String> {
}
