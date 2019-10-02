package com.Ganges.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Ganges.Bean.Kart;
import com.Ganges.Bean.OrderDetails;
import com.Ganges.Bean.OrderHeader;
import com.Ganges.Bean.Product;
import com.Ganges.Bean.Transaction;
import com.Ganges.DAO.PageLoaderDAO;

@Component
public class PageLoaderService {
	
	@Autowired
	private PageLoaderDAO dao;
	
	public List<Product> getProductList(){
		
		List<Product> productBeanList = new ArrayList<Product>();
		productBeanList = dao.getProductList();
		return productBeanList;
	}
	
	public Boolean addProductToKart(Product product,String username) {
		Kart kartBean = new Kart();
		kartBean.setUsername(username);
		kartBean.setOffer(product.getOffer());
		kartBean.setPrice(product.getPrice());
		kartBean.setProductId(product.getProductId());
		kartBean.setProductName(product.getProductName());
		kartBean.setProductUrl(product.getProductUrl());
		Boolean status = dao.addProductToKart(kartBean);
		return status;
	}
	
	public Product getProductDetails(Integer productId) {
		Product product = dao.getProductDetails(productId);
		return product;
	}
	
	public List<Kart> getMyKartList(String user){
		List<Kart> myKartList = dao.getMyKartList(user);
		return myKartList;
	}
	
	public void removeProductFromMyKart(Integer kartNumber) {
		Boolean status = dao.removeProductFromMyKart(kartNumber);
		if(status == true) {
			System.out.println("Row deleted");
		}
		else {
			System.out.println("Row not deleted");
		}
	}
	
	public List<OrderHeader> getMyOrderList(String user){
		List<OrderHeader> orderList = new ArrayList<OrderHeader>();
		orderList = dao.getMyOrderList(user);
		return orderList;
	}
	
	public String placeOrder(Integer productId,Transaction transaction,String username) {
		return dao.placeOrder(productId,transaction,username);
	}
	
	public OrderDetails getOrderDetails(Integer orderHeaderId) {
		return dao.getOrderDetails(orderHeaderId);
	}
	
	public OrderHeader getOrderHeader(Integer orderHeaderId) {
		return dao.getOrderHeader(orderHeaderId);
	}
}
