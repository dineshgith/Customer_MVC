package com.customers.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.customers.entity.Customers;
import com.customers.interf.CustomerDao;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public Customers getCustomerById(int customerId) {
		return hibernateTemplate.get(Customers.class, customerId);
	}

	@Transactional
	public void addCustomer(Customers customer) {
		hibernateTemplate.save(customer);
	}

	public void updateCustomer(Customers customer) {
		Customers cust = getCustomerById(customer.getCustomerId());
		cust.setFirstName(customer.getFirstName());
		cust.setMiddleName(customer.getMiddleName());
		cust.setLastName(customer.getLastName());
		cust.setTitle(customer.getTitle());
		cust.setSuffix(customer.getSuffix());
		hibernateTemplate.update(cust);
	}

	public void deleteCustomer(int customerId) {
		hibernateTemplate.delete(getCustomerById(customerId));
	}

}
