package com.optica.atos.customer.service;

import com.optica.atos.customer.domain.Customer;
import com.optica.atos.customer.domain.OpticaParent;
import com.optica.atos.customer.exceptions.CustomerException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    /**
     * Get data from repository
     * @return
     * @throws CustomerException
     */
    @Override
    public OpticaParent getCustomers() throws CustomerException {

        return OpticaParent.builder().customers(dummyCustomerList()).build();
    }

    /**
     * Get data from repository
     * @param id
     * @return
     * @throws CustomerException
     */
    @Override
    public OpticaParent removeCustomer(String id) throws CustomerException {
        List<Customer> list = dummyCustomerList();

        List<Customer> modifiedList = list.stream()
                .filter(c -> !c.getId().equalsIgnoreCase(id))
                .collect(Collectors.toList());

        return OpticaParent.builder().customers(modifiedList).build();
    }

    /**
     * Get data from repository
     * @param customer
     * @return
     * @throws CustomerException
     */
    @Override
    public OpticaParent addCustomer(Customer customer) throws CustomerException {


        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        customers.addAll(dummyCustomerList());

        return OpticaParent.builder().customers(customers).build();
    }


    /**
     * Remove after repository
     * @return
     */
    private List<Customer> dummyCustomerList() {

        Customer customer1 = Customer.builder()
                .id("A12345")
                .firstName("Satish")
                .lastName("Yeruva")
                .build();

        Customer customer2 = Customer.builder()
                .id(UUID.randomUUID().toString())
                .firstName("Steve")
                .lastName("Jobs")
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


        return Arrays.asList(customer1, customer2, customer3, customer4);
    }

}
