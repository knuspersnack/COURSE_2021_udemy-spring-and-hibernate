package com.udemy.mvc.repository;

import com.udemy.mvc.entity.Customer;

import java.util.List;

public interface CustomerRepository {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
