package com.cassioroos.graphqldocker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cassioroos.graphqldocker.domain.Customers;

@Repository
public interface CustomersRepository extends MongoRepository<Customers, String>{

}
