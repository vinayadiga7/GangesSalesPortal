package com.Ganges.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.Ganges.Bean.Customer;
import com.Ganges.Entity.CustomerEntity;
import com.Ganges.Exception.LoginException;

@Component
public class RegistrationDAO {
	
		@PersistenceContext
		private EntityManager em;
		
		public CustomerEntity checkLogin(Customer customer) throws LoginException {
			
			CustomerEntity customerEntity = em.find(CustomerEntity.class, customer.getUsername());
			if(customerEntity==null)
			{
				throw new LoginException("Cannot Login, Username is incorrect");
			}
			else if(customer.getPassword().equals(customerEntity.getPassword()))
			{
				return customerEntity;
			}
			else
			{
				throw new LoginException("Login Failed, password is incorrect");
			}
		}
}
