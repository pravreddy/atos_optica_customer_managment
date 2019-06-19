package com.optica.atos.customer.dao;

import com.optica.atos.customer.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Repository
public class CustomerServiceDaoImpl implements CustomerServiceDao {

    Customer customer1 = Customer.builder()
            .id("A12345")
            .firstName("John")
            .lastName("Doe")
            .build();

    Customer customer2 = Customer.builder()
            .id(UUID.randomUUID().toString())
            .firstName("Steve")
            .lastName("smith")
            .build();

    Customer customer3 = Customer.builder()
            .id(UUID.randomUUID().toString())
            .firstName("James")
            .lastName("Gosling")
            .build();

    Customer customer4 = Customer.builder()
            .id(UUID.randomUUID().toString())
            .firstName("Martin")
            .lastName("Fowler")
            .build();

    private List<Customer> customerList = Arrays.asList(customer1, customer2, customer3, customer4);

    @Override
    public List<Customer> getCustomerList() {
        return this.customerList;
    }

    @Override
    public void setCustomerList(List<Customer> newCustomerList) {
        this.customerList = newCustomerList;
    }

}
