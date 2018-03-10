package com.customers.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.customers.entity.Customers;
import com.customers.interf.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerServiceImpl;

	@RequestMapping(value = "model", method = RequestMethod.GET)
	public String users(@ModelAttribute Customers customer, BindingResult result, ModelMap model) {
		System.out.println("controller called");
		model.addAttribute("customers", new Customers());
		return "customerform";

	}

	@RequestMapping(value = "addCustomer", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("customer") Customers customer, BindingResult result, ModelMap model) {
		if (!result.hasErrors()) {
			customerServiceImpl.addCustomer(customer);
		}
		model.addAttribute("customers", customer);
		return "customerform";
	}

	@RequestMapping(value = "customerById")
	public String getCustomerById(ModelMap model, @RequestParam("customerId") int customerId, BindingResult result) {
		Customers customer = customerServiceImpl.getCustomerById(customerId);
		model.addAttribute("customer", customer);
		return "customerform";
	}

	@RequestMapping(value = "updateCustomer", method = RequestMethod.POST)
	public String updatePerson(@ModelAttribute("customer") Customers customer, BindingResult result, ModelMap model) {
		if (!result.hasErrors()) {
			customerServiceImpl.updateCustomer(customer);
		}
		return "customerform";
	}

	@RequestMapping(value = "deleteCustomer")
	public String deletePerson(ModelMap model, HttpServletRequest request) {
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		customerServiceImpl.deletePerson(customerId);
		return "customerform";
	}

}
