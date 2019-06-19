package com.optica.atos.customer.service;

import com.optica.atos.customer.dao.CustomerServiceDao;
import com.optica.atos.customer.domain.Customer;
import com.optica.atos.customer.domain.OpticaParent;
import com.optica.atos.customer.exceptions.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerServiceDao customerServiceDao;

    /**
     * Get data from repository
     * @return
     * @throws CustomerException
     */
    @Override
    public OpticaParent getCustomers() throws CustomerException {

        return OpticaParent.builder().customers(customerServiceDao.getCustomerList()).build();
    }

    /**
     * Get data from repository
     * @param id
     * @return
     * @throws CustomerException
     */
    @Override
    public OpticaParent removeCustomer(String id) throws CustomerException {
        List<Customer> list = customerServiceDao.getCustomerList();

        List<Customer> modifiedList = list.stream()
                .filter(c -> !c.getId().equalsIgnoreCase(id))
                .collect(Collectors.toList());

        customerServiceDao.setCustomerList(modifiedList);

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
        customers.addAll(customerServiceDao.getCustomerList());
        customerServiceDao.setCustomerList(customers);

        return OpticaParent.builder().customers(customers).build();
    }

}
