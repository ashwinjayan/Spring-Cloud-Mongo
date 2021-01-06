package com.example.mongodbapp;

import com.example.mongodbapp.model.Customer;
import com.example.mongodbapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MongodbappApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongodbappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Customer> customerList = new ArrayList<>();

		customerList.add(new Customer(1, "Ashwin", "Jayan"));
		customerList.add(new Customer(2, "Pratheek", "P M"));
		customerList.add(new Customer(3, "Rohan", "P K"));
		customerList.add(new Customer(4, "Adarsh", "P K"));
		customerRepository.saveAll(customerList);
	}
}
