package com.greatlearning.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greatlearning.crm.dao.CustomerDAO;
import com.greatlearning.crm.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public List<Customer> findAll() {

		return customerDAO.findAll();
	}

	@Override
	public Customer findById(int theId) {

		return customerDAO.findById(theId);
	}

	@Override
	public void save(Customer theCustomer) {

		customerDAO.save(theCustomer);
	}

	@Override
	public void deleteById(int theId) {

		customerDAO.deleteById(theId);

	}

	@Override
	public void update(Customer theCustomer) {

		customerDAO.update(theCustomer);

	}

}
