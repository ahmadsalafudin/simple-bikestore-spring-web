package com.batm.tokoBatch3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.batm.tokoBatch3.model.Customer;
import com.batm.tokoBatch3.service.CustomerService;

@Controller
public class CustomerController {
	
	private CustomerService customerService;

	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping("/customer")
	public String Customer(Model model) {
		model.addAttribute("customer", customerService.listCustomer());
		return "customer";
	}

	@RequestMapping(value = "/customer/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {

		model.addAttribute("customer", new Customer());
		return "formAddCustomer";
	}

	@RequestMapping(value = "/customer/create", method = RequestMethod.POST)
	public String simpanDataCustomer(Model model, Customer customer) {
		model.addAttribute("customer", customerService.saveOrUpdate(customer));
		return "redirect:/customer";
	}

	@RequestMapping(value = "/customer/edit/{idCustomer}", method = RequestMethod.GET)
	public String editData(@PathVariable Integer idCustomer, Model model) {
		model.addAttribute("customer", customerService.getIdUser(idCustomer));
		return "formEditCustomer";
	}

	@RequestMapping(value = "/customer/hapus/{idCustomer}")
	public String hapus(@PathVariable Integer idCustomer) {
		customerService.hapus(idCustomer);
		return "redirect:/customer";
	}
}
