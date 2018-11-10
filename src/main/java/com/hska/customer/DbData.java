package com.hska.customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class DbData implements CommandLineRunner {
    private CustomerRepository customerRepository;

    public DbData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... strings) throws Exception{

        Customer customer1 = new Customer(
                "Martin",
                "Müller",
                "Baumstraße 4; 45025 Bielefeld",
                5000
        );

        Customer customer2 = new Customer(
                "Uwe",
                "Maier",
                "Feldweg 46; 29483 Dortmund",
                2045
        );

        Customer customer3 = new Customer(
                "Sandra",
                "Fischer",
                "Am unteren Bach; 93754 Leipzig",
                700
        );

        Customer customer4 = new Customer(
                "Achim",
                "Sommer",
                "Tannenweg 87; 83753 Nürnberg",
                1500
        );

        Customer customer5 = new Customer(
                "Silvia",
                "Busch",
                "Am Steinweg 4; 82657 Cottbus",
                11000
        );

        //komplette Datensätze löschen
        this.customerRepository.deleteAll();

        //Datensätze in die Datenbank einfügen
        List<Customer> customers = Arrays.asList(customer1, customer2, customer3, customer4, customer5);
        this.customerRepository.saveAll(customers);

    }
}
