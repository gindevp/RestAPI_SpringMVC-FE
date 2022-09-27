package com.codegym.demoajax.controller;

import com.codegym.demoajax.model.Customer;
import com.codegym.demoajax.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @GetMapping
    public ResponseEntity <Iterable<Customer>> showAll(){
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

}
