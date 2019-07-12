package com.batm.tokoBatch3.service;

import java.util.List;

import com.batm.tokoBatch3.model.Customer;

public interface CustomerService {
	List<Customer> listCustomer();

	Customer saveOrUpdate(Customer Customer);

	Customer getIdUser(Integer id);

	void hapus(Integer id);

}
