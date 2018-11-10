package com.hska.customer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{
    List<Customer> findAllByNachname(String nachname);
    Customer findAllById(String nummer);
    List<Customer> findAllByNachnameAndVorname(String nachname, String vorname);
}
