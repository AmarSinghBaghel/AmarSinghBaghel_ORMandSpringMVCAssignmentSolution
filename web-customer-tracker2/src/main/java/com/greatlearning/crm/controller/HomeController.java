package com.greatlearning.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.crm.entity.Customer;
import com.greatlearning.crm.service.CustomerService;

@Controller
public class HomeController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/")
	public String index(Model theModel) {
		System.out.println("request recieved for home page");
		// get student from db
		List<Customer> theStudents = customerService.findAll();

		// add to the spring model
		theModel.addAttribute("Customer", theStudents);

		return "redirect:/customer/list";
	}

}
