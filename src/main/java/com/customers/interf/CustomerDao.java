package com.customers.interf;

import com.customers.entity.Customers;

public interface CustomerDao {

	public Customers getCustomerById(int customerId);

	public void addCustomer(Customers customer);

	public void updateCustomer(Customers customer);

	public void deleteCustomer(int customerId);

}
