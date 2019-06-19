package com.optica.atos.customer.service;

import com.optica.atos.customer.domain.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Before
    public void setUp() throws Exception {
        
    }

    @Test
    public void given_user_when_submits_then_gets_all_customers() {

        List<Customer> customers = customerService.getCustomers().getCustomers();

       Assert.assertEquals(4,customers.size());
    }


    @Test
    public void given_customer_when_adds_then_successfully_add_customer() {
        Customer customerBuilder = Customer.builder()
                .id(UUID.randomUUID().toString())
                .firstName("Satish1")
                .lastName("Yeruva1")
                .build();
        List<Customer> customers = customerService.addCustomer(customerBuilder).getCustomers();


       Assert.assertEquals("Satish1",customers.get(0).getFirstName());
    }

    @Test
    public void given_customer_when_removes_then_successfully_removed() {
        List<Customer> customers = customerService.getCustomers().getCustomers();
        List<Customer> customerList = customerService.removeCustomer("A12345").getCustomers();

        Assert.assertEquals(customers.size()-1,customerList.size());
    }

}
