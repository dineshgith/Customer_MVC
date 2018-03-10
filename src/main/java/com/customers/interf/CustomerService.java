package com.customers.interf;

import com.customers.entity.Customers;

public interface CustomerService {

	Customers getCustomerById(int customerId);

	public void updateCustomer(Customers customer);

	void deletePerson(int pid);

	void addCustomer(Customers customer);

}
