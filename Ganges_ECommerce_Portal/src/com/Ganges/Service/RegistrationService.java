package com.Ganges.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Ganges.Bean.Customer;
import com.Ganges.DAO.RegistrationDAO;
import com.Ganges.Entity.CustomerEntity;
import com.Ganges.Exception.LoginException;

@Component
public class RegistrationService {
	
	@Autowired
	private RegistrationDAO dao;
	
	public Customer checkLogin(Customer customer) throws LoginException {
		
		CustomerEntity customerEntity = dao.checkLogin(customer);
		Customer customerBean = new Customer();
		
			customerBean.setCustomerId(customerEntity.getCustomerId());
			customerBean.setAddressLine1(customerEntity.getAddressLine1());
			customerBean.setAddressLine2(customerEntity.getAddressLine2());
			customerBean.setCity(customerEntity.getCity());
			customerBean.setCountry(customerEntity.getCountry());
			customerBean.setCustomerName(customerEntity.getCustomerName());
			customerBean.setEmail(customerEntity.getEmail());
			customerBean.setPhone(customerEntity.getPhone());
			customerBean.setPincode(customerEntity.getPinCode());
			customerBean.setState(customerEntity.getState());
			customerBean.setUsername(customerEntity.getUsername());
		
		return customerBean;
	}
}
