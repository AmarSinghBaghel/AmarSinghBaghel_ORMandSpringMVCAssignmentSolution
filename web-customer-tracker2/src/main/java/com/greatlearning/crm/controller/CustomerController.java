package com.greatlearning.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.greatlearning.crm.entity.Customer;
import com.greatlearning.crm.service.CustomerService;

@Controller

@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public String listBooks(Model theModel) {

		System.out.println("request recieved");
		// get customer list from db
		List<Customer> theStudents = customerService.findAll();

		// add to the spring model
		theModel.addAttribute("Customer", theStudents);

		return "list-customer";
	}

	@RequestMapping(value = "/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Customer theCustomer = new Customer();

		theModel.addAttribute("Customer", theCustomer);

		return "customer-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

		// get the customer from the service
		Customer theCustomer = customerService.findById(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("Customer", theCustomer);

		// send over to our form
		return "customer-form";
	}

	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("course") String email) {

		System.out.println(id);
		Customer theCustomer;
		if (id != 0) {
			theCustomer = customerService.findById(id);
			theCustomer.setFirstname(firstName);
			theCustomer.setLastname(lastName);
			theCustomer.setEmail(email);

		} else
			theCustomer = new Customer(firstName, lastName, email);

		customerService.save(theCustomer);

		// use a redirect to prevent duplicate submissions
		return "redirect:/customer/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {

		// delete the student
		customerService.deleteById(theId);

		// redirect to /student/list
		return "redirect:/customer/list";

	}

}
