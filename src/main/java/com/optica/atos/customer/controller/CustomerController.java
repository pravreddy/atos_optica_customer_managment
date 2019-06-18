package com.optica.atos.customer.controller;

import com.optica.atos.customer.common.ContractEndpoint;
import com.optica.atos.customer.domain.Customer;
import com.optica.atos.customer.domain.OpticaParent;
import com.optica.atos.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ContractEndpoint.DEFAULT)
public class CustomerController {


    @Autowired
    CustomerService customerService;

    @RequestMapping
    public OpticaParent getCustomers() {

        return customerService.getCustomers();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<OpticaParent> deleteCustomer(@PathVariable String id) {

        if(id != null && !StringUtils.isEmpty(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(customerService.removeCustomer(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PostMapping
    public ResponseEntity<OpticaParent> addCustomer(@RequestBody Customer customer) {

        if(customer.getId() != null) {
            return ResponseEntity.status(HttpStatus.OK).body(customerService.addCustomer(customer));
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

}
