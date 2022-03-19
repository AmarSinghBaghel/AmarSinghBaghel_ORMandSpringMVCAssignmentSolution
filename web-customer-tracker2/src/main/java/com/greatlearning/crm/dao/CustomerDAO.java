package com.greatlearning.crm.dao;

import java.util.List;

import com.greatlearning.crm.entity.Customer;

public interface CustomerDAO {

	public List<Customer> findAll();

	public Customer findById(int theId);

	public void save(Customer theCustomer);

	public void deleteById(int theId);

}
