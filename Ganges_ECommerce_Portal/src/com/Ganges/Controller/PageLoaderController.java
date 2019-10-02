package com.Ganges.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.Ganges.Bean.Kart;
import com.Ganges.Bean.OrderDetails;
import com.Ganges.Bean.OrderHeader;
import com.Ganges.Bean.Product;
import com.Ganges.Bean.Transaction;
import com.Ganges.Entity.OrderHeaderEntity;
import com.Ganges.Service.PageLoaderService;



@Controller

public class PageLoaderController {
	
	@Autowired
	 PageLoaderService service;
	
	
	
	@RequestMapping("/getListOfProducts.vin")
	public ModelAndView loadProductsOnPage() {
		System.out.println("in getListOfProducts.vin");
		ModelAndView modelAndView = new ModelAndView();
		List<Product> productList = new ArrayList<Product>();
		productList = getProductList();
		modelAndView.addObject("productList", productList);
		modelAndView.setViewName("CustomerHomePage");
		System.out.println("After getting productlist "+productList.size());
		System.out.println("From Second commit - Controller");
		return modelAndView;
	}
	
	
	public List<Product> getProductList() {
		
		List<Product> productList = new ArrayList<Product>();
		productList = service.getProductList();
		return productList;
	}
	
	@RequestMapping("/addProductToKart.vin")
	public ModelAndView addProductToKart(HttpServletRequest request) {
	
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		Product product = service.getProductDetails(productId);
		Boolean status = service.addProductToKart(product,request.getSession().getAttribute("user").toString());
		System.out.println("Status of adding kart: "+status);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("productSelected",product);
		mv.setViewName("ProductHomePage");
		return mv;
	}
	
	@RequestMapping("/getProductPage.vin")
	public ModelAndView getProductDetails(HttpServletRequest request) {
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		Product product= service.getProductDetails(productId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("productId", request.getParameter("productId"));
		mv.addObject("productSelected",product);
		mv.setViewName("ProductHomePage");
		return mv;
	}
	
	@RequestMapping("/getMyKart.vin")
	public ModelAndView getMyKartList(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		List<Kart> myKartProductList = service.getMyKartList(session.getAttribute("user").toString());
		mv.addObject("myKartProductList", myKartProductList);
		for (Kart kart : myKartProductList) {
			System.out.println("Kart Number: "+kart.getKartNumber());
		}
		mv.setViewName("myKartHomePage");
		return mv;
	}
	
	@RequestMapping("/removeProductFromMyKart.vin")
	public ModelAndView removeProductFromMyKart(HttpServletRequest request,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Integer kartNumber = Integer.parseInt(request.getParameter("kartNumber"));
		service.removeProductFromMyKart(kartNumber);
		List<Kart> myKartList = service.getMyKartList(session.getAttribute("user").toString());
		mv.addObject("myKartProductList", myKartList);
		mv.setViewName("myKartHomePage");
		return mv;
	}
	
	@RequestMapping(value="/getMyOrders.vin")
	public ModelAndView getMyOrders(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("OrderHeaderPage");
		String user = session.getAttribute("user").toString();
		List<OrderHeader> orderList = service.getMyOrderList(user);
		List<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();
		/*for (OrderHeader orderHeader : orderList) {
			OrderDetails orderDetailsBean = service.getOrderDetails(orderHeader.getOrderHeaderId());
			orderDetailsList.add(orderDetailsBean);
		}*/
//		OrderDetails orderDetailsBean = service.getOrderDetails(orderHeader.getOrderHeaderId());
		modelAndView.addObject("orderList", orderList);
		modelAndView.addObject("orderDetailsList", orderDetailsList);
		return modelAndView;
	}
	
	@RequestMapping(value="/byProductNow.vin")
	public ModelAndView getOrderPage(HttpServletRequest request, ModelMap model) {
		ModelAndView modelAndView = new ModelAndView();
		Transaction transaction = new Transaction();
		model.put("transactionBean", transaction);
		modelAndView.setViewName("PaymentPage");
		Integer kartNumber = Integer.parseInt(request.getParameter("kartNumber"));
		service.removeProductFromMyKart(kartNumber);
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		Product product = service.getProductDetails(productId);
		Double amount = product.getPrice();
		System.out.println(product);
		if(product.getIsGangesOfferThere())
		{
			amount = amount-(product.getPrice()*(product.getGangesOffer()/100));
		}
		if(product.getIsPromotionalOfferThere())
		{
			amount = amount-(product.getPrice()*(product.getPromotionalOffer()/100));
		}
		transaction.setAmount(amount);
		model.put("product", product);
		return modelAndView;
	}
	
	@RequestMapping("/completeOrder.vin")
	public ModelAndView placeOrder(@ModelAttribute Transaction transactionBean,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		Integer productId = Integer.parseInt(request.getParameter("productId"));
		String username = (String) request.getSession().getAttribute("user");
		System.out.println("hi");
		String messageAboutOrderStatus = service.placeOrder(productId,transactionBean,username);
		System.out.println("hello");
		modelAndView.addObject("messageAboutOrderStatus", messageAboutOrderStatus);
		modelAndView.setViewName("OrderStatusPage");
		return modelAndView;
	}
	
	@RequestMapping("/getOrderDetailsPage.vin")
	public ModelAndView getOrderDetails(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		Integer orderHeaderId = Integer.parseInt(request.getParameter("orderHeaderId"));
		OrderDetails orderDetails = service.getOrderDetails(orderHeaderId);
		Product product = service.getProductDetails(orderDetails.getProductId());
		OrderHeader orderHeader = service.getOrderHeader(orderHeaderId);
		modelAndView.addObject("product", product);
		modelAndView.addObject("orderDetails", orderDetails);
		modelAndView.addObject("orderHeader", orderHeader);
		modelAndView.setViewName("OrderDetailsPage");
		return modelAndView;
	}
}
