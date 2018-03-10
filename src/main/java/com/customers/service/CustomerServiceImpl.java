package com.customers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customers.entity.Customers;
import com.customers.interf.CustomerDao;
import com.customers.interf.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customers getCustomerById(int customerId) {
		Customers cust = customerDao.getCustomerById(customerId);
		return cust;
	}

	@Override
	public void addCustomer(Customers customer) {
		customerDao.addCustomer(customer);
		}

	@Override
	public void updateCustomer(Customers customer) {
		customerDao.updateCustomer(customer);
	}

	@Override
	public void deletePerson(int customerId) {
		customerDao.deleteCustomer(customerId);
	}

}
