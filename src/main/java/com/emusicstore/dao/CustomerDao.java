package com.emusicstore.dao;

import com.emusicstore.model.Customer;
import com.emusicstore.model.Product;

import java.util.List;

/**
 * Created by Le on 1/25/2016.
 */
public interface CustomerDao {

    void addCustomer (Customer customer);

    Customer getCustomerById (int customerId);

    List<Product> getProductByType(String type);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername (String username);



}
