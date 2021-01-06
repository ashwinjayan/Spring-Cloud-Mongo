package com.example.mongodbapp.controller;

import com.example.mongodbapp.model.Customer;
import com.example.mongodbapp.model.DBSettings;
import com.example.mongodbapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Value("${my.greeting}")
    private String configValue;

    @Autowired
    private DBSettings dbSettings;

    @GetMapping(value="/all")
    public List<Customer> getAllStudents() {
        return customerRepository.findAll();
    }

    @GetMapping(value="/valuefromconfig")
    public String getConfigValue() {
        return configValue + dbSettings.getConnection();
    }

    @PostMapping(value = "/create")
    public String createStudent(@RequestBody Customer customer) {
        customerRepository.insert(customer);
        return "Customer added : " + customer.getFirstName();
    }

}
