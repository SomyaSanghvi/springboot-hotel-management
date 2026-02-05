package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository repo;

    public CustomerController(CustomerRepository repo) {
        this.repo = repo;
    }

    // CREATE
    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer customer) {
        repo.save(customer);
        return "Customer added";
    }

    // READ
    @GetMapping("/all")
    public List<Customer> getCustomers() {
        return repo.findAll();
    }

    // UPDATE
    @PutMapping("/update")
    public String updateCustomer(@RequestBody Customer customer) {
        repo.save(customer);
        return "Customer updated";
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id) {
        repo.deleteById(id);
        return "Customer deleted";
    }
}
