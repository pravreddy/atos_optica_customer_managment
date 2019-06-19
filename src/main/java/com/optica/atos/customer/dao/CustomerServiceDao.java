package com.optica.atos.customer.dao;

import com.optica.atos.customer.domain.Customer;
import java.util.List;

public interface CustomerServiceDao {
    public List<Customer> getCustomerList();
    public void setCustomerList(List<Customer> customerList);
}
