package com.optica.atos.customer.service;

import com.optica.atos.customer.domain.Customer;
import com.optica.atos.customer.domain.OpticaParent;
import com.optica.atos.customer.exceptions.CustomerException;

import java.util.List;

public interface CustomerService {

    OpticaParent getCustomers() throws CustomerException;

    OpticaParent removeCustomer(String id) throws CustomerException;

    OpticaParent addCustomer(Customer customer) throws CustomerException;

}
