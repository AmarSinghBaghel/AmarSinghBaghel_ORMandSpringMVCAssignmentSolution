package com.greatlearning.crm.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.greatlearning.crm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {


	private SessionFactory sessionFactory;

	// create session
	private Session session;

	@Autowired
	CustomerDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}

	@Transactional
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		List<Customer> customer = session.createQuery("from Customer", Customer.class).list();

		tx.commit();

		return customer;

	}

	@Transactional
	public Customer findById(int theId) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, theId);

		tx.commit();
		return customer;

	}

	@Transactional
	public void save(Customer theCustomer) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(theCustomer);
		tx.commit();

	}

	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();

		try {
			Customer customer = session.get(Customer.class, theId);
			session.delete(customer);
		} finally {
			tx.commit();
		}

	}

	/*
	 * @Transactional public void update(Customer theCustomer) { Transaction tx =
	 * session.beginTransaction(); session.saveOrUpdate(theCustomer); tx.commit();
	 * 
	 * }
	 */

}
