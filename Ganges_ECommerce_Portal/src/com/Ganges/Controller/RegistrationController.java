package com.Ganges.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.Ganges.Bean.Customer;
import com.Ganges.Exception.LoginException;
import com.Ganges.Service.RegistrationService;

@Controller
@SessionAttributes("user")
public class RegistrationController {
	
		@Autowired
		private RegistrationService service;
				
		@RequestMapping("/checkLogin.vin")
		public ModelAndView checkLogin(Customer customer) {
			ModelAndView modelAndView = new ModelAndView();
			Customer customerToPrint = new Customer();
			String message = new String();
			try {
				customerToPrint = service.checkLogin(customer);
				message="You have successfully logged in";
				System.out.println(message+customerToPrint);
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				message=e.getMessage();
				e.printStackTrace();
			}
			modelAndView.addObject("MESSAGE", message);
			modelAndView.addObject("user", customerToPrint.getUsername());
			modelAndView.setViewName("CustomerHomePage");
			return modelAndView;
		}
		
		@RequestMapping("/loginPage.vin")
		public ModelAndView displayLoginPage() {
		
			ModelAndView mv = new ModelAndView();
			Customer customer = new Customer();
			mv.addObject("customer", customer);
			mv.setViewName("LoginPage");
			return mv;
		}
		
		@RequestMapping("/makeMeLogout.vin")
		public ModelAndView logout(HttpSession session) {
			session.invalidate();
			ModelAndView modelAndView = new ModelAndView();
			Customer customer = new Customer();
			modelAndView.addObject("customer", customer);
			modelAndView.setViewName("LoginPage");
			return modelAndView;
		}
		
		@RequestMapping("/LoadCustomerHomePage.vin")
		public ModelAndView loadHomePage() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("CustomerHomePage");
			return modelAndView;
			
		}
}
