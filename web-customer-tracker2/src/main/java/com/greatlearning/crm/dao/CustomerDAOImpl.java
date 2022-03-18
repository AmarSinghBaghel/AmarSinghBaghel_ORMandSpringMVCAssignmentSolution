package com.greatlearning.crm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.crm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	@Transactional
	public List<Customer> findAll() {

		String sql = "SELECT * FROM customer_table";
		List<Customer> customer = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Customer.class));

		return customer;
	}

	@Transactional
	public Customer findById(int theId) {
		String sql = "SELECT * FROM customer_table where id =" + theId + "";
		Customer customer = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Customer.class));
		return customer;
	}

	@Transactional
	public void save(Customer theCustomer) {

		String sql = "Insert into customer.customer_table(firstname,lastname,email) values ('"
				+ theCustomer.getFirstname() + "','" + theCustomer.getLastname() + "','" + theCustomer.getEmail()
				+ "')";

		jdbcTemplate.update(sql);

	}

	@Transactional
	public void deleteById(int theId) {

		String sql = "Delete from customer.customer_table  Where id = " + theId + "";
		jdbcTemplate.update(sql);
	}

	@Transactional
	public void update(Customer theCustomer) {

		String sql = "Update customer.customer_table set firstname = '" + theCustomer.getFirstname() + "', lastname ='"
				+ theCustomer.getLastname() + "',email = '" + theCustomer.getEmail() + "' Where id = "
				+ theCustomer.getId() + "";
		jdbcTemplate.update(sql);

	}

}
