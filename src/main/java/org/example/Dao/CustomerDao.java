package org.example.Dao;

import org.example.Model.Customer;

import java.util.List;

public interface CustomerDao {
    Customer getCustomerById(long id);

    List<Customer> getAllCustomers();

    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(long id);
}
