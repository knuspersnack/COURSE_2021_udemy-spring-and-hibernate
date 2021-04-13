package com.udemy.mvc.repository;

import com.udemy.mvc.entity.Customer;

import java.util.List;


public interface CustomerRepository {

	List<Customer> getCustomers();

	void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId);

	void deleteCustomer(int theId);
}
