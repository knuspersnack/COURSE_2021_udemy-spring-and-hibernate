package com.udemy.mvc.dao;

import com.udemy.mvc.entity.Customer;

import java.util.List;


public interface CustomerRepository {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	
}
