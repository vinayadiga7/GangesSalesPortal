package com.Ganges.DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.Ganges.Bean.Kart;
import com.Ganges.Bean.OrderDetails;
import com.Ganges.Bean.OrderHeader;
import com.Ganges.Bean.Product;
import com.Ganges.Bean.Transaction;
import com.Ganges.Entity.CustomerEntity;
import com.Ganges.Entity.KartEntity;
import com.Ganges.Entity.OrderDetailsEntity;
import com.Ganges.Entity.OrderHeaderEntity;
import com.Ganges.Entity.ProductEntity;
import com.Ganges.Entity.TransactionEntity;

@Component
public class PageLoaderDAO {
	
		@PersistenceContext
		private EntityManager em;
		
		public List<Product> getProductList(){
			List<Product> productBeanList = new ArrayList<Product>();
			List<ProductEntity> productEntityList = new ArrayList<ProductEntity>();
			Query query = em.createQuery("select p from ProductEntity p");
			
			productEntityList = query.getResultList();
			
			for (ProductEntity productEntity : productEntityList) {
				Product productBean = new Product();
				productBean.setCompany(productEntity.getCompany());
				productBean.setDescription(productEntity.getDescription());
				productBean.setPrice(productEntity.getPrice());
				productBean.setProductId(productEntity.getProductId());
				productBean.setProductName(productEntity.getProductName());
				productBean.setProductUrl(productEntity.getProductUrl());
				productBean.setRating(productEntity.getRating());
				
				productBeanList.add(productBean);
			}
			
			return productBeanList;
		}
		
		@Transactional
		public Boolean addProductToKart(Kart kartBean) {
			KartEntity kartEntity = new KartEntity();
			Query queryForCheckingDuplicateKartEntry = em.createQuery("Select k from KartEntity k where k.customer=:customer and k.product=:product"); 	
			ProductEntity product = em.find(ProductEntity.class, kartBean.getProductId());
			CustomerEntity customer = em.find(CustomerEntity.class,kartBean.getUsername());
			queryForCheckingDuplicateKartEntry.setParameter("customer", customer);
			queryForCheckingDuplicateKartEntry.setParameter("product", product);
			try {
			KartEntity kartEntityForCheck= (KartEntity) queryForCheckingDuplicateKartEntry.getSingleResult();
			}
			catch(Exception e) {
				kartEntity.setCustomer(customer);
				kartEntity.setProduct(product);
				
				
				em.persist(kartEntity);
			}
			
			if(kartEntity!=null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		
		public Product getProductDetails(Integer productId) {
			Product product = new Product();
			ProductEntity productEntity = em.find(ProductEntity.class,productId);
			product.setCompany(productEntity.getCompany());
			product.setDescription(productEntity.getDescription());
			product.setPrice(productEntity.getPrice());
			product.setProductId(productEntity.getProductId());
			product.setProductName(productEntity.getProductName());
			product.setProductUrl(productEntity.getProductUrl());
			product.setRating(productEntity.getRating());
			product.setProductDetails(productEntity.getProductDetails());
			product.setIsPromotionalOfferThere(productEntity.getIsPromotionalDiscountThere());
			product.setPromotionalOffer(productEntity.getPromotionalDiscount());
			product.setIsGangesOfferThere(productEntity.getIsGangesDiscountThere());
			product.setGangesOffer(productEntity.getGangesDiscount());
			
			return product;
		}
		
		public List<Kart> getMyKartList(String user){
			Query query = em.createQuery("select k from KartEntity k where k.customer=:customerEntity");
			CustomerEntity customerEntity = em.find(CustomerEntity.class, user);
			query.setParameter("customerEntity", customerEntity);
			List<KartEntity> kartEntityList = query.getResultList();
			List<Kart> kartList = new ArrayList<Kart>();
			for (KartEntity kartEntity : kartEntityList) {
				Kart kartBean = new Kart();
				kartBean.setPrice(kartEntity.getProduct().getPrice());
				kartBean.setProductId(kartEntity.getProduct().getProductId());
				kartBean.setProductName(kartEntity.getProduct().getProductName());
				kartBean.setProductUrl(kartEntity.getProduct().getProductUrl());
				kartBean.setCompany(kartEntity.getProduct().getCompany());
				kartBean.setKartNumber(kartEntity.getKartNumber());
			
				kartList.add(kartBean);
			}
			return kartList;
		}
		
		@Transactional
		public Boolean removeProductFromMyKart(Integer kartNumber) {
			KartEntity kartEntity = em.find(KartEntity.class, kartNumber);
			em.remove(kartEntity);
			if(em.find(KartEntity.class,kartNumber)==null) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public List<OrderHeader> getMyOrderList(String username){
			List<OrderHeader> orderList = new ArrayList<OrderHeader>();
			CustomerEntity customerEntity = em.find(CustomerEntity.class, username);
			Query query = em.createQuery("select o from OrderHeaderEntity o where o.customer=:customerEntity");
			query.setParameter("customerEntity", customerEntity);
			List<OrderHeaderEntity> orderHeaderEntityList = query.getResultList();
			for (OrderHeaderEntity orderHeaderEntity : orderHeaderEntityList) {
				OrderHeader orderHeaderBean = new OrderHeader();
				orderHeaderBean.setCustomerFullName(orderHeaderEntity.getCustomer().getCustomerName());
				orderHeaderBean.setCustomerUsername(orderHeaderEntity.getCustomer().getUsername());
				orderHeaderBean.setDeliveryDate(orderHeaderEntity.getDeliveryDate().getTime().toString());
				orderHeaderBean.setOrderDate(orderHeaderEntity.getOrderDate().getTime().toString());
				orderHeaderBean.setOrderHeaderId(orderHeaderEntity.getOrderHeaderId());
				orderHeaderBean.setShipmentAddress(orderHeaderEntity.getAddress());
				orderHeaderBean.setStatus(orderHeaderEntity.getStatus());
				orderHeaderBean.setTotalAmount(orderHeaderEntity.getTotalAmont());
				orderHeaderBean.setTransactionId(orderHeaderEntity.getTransaction().getTransactionId());
				orderList.add(orderHeaderBean);	
				}
			return orderList;
		}
		
		@Transactional
		public String placeOrder(Integer productId,Transaction transaction,String username) {
			
			StringBuilder messageAboutOrderStatus = new StringBuilder();
			OrderHeaderEntity orderHeaderEntity = new OrderHeaderEntity();
			TransactionEntity transactionEntity = new TransactionEntity();
			OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();
			ProductEntity productEntity = em.find(ProductEntity.class, productId);
			CustomerEntity customerEntity = em.find(CustomerEntity.class, username);
			System.out.println(transaction);
			transactionEntity.setAmount(transaction.getAmount());
			transactionEntity.setFromAccountCardNumber(transaction.getFromAccountCardNumber());
			transactionEntity.setFromCardCVV(transaction.getFromCardCVV());
			transactionEntity.setFromCardExpiryDate(transaction.getFromCardExpiryDate());
			transactionEntity.setStatus("pending");
			transactionEntity.setToAccountCardNumber("2222333344445555");
			transactionEntity.setTransactionDate(Calendar.getInstance());
			transactionEntity.setTransactionReferenceNumber("TRN-00001");
			
			em.persist(transactionEntity);
			
			em.createQuery("update TransactionEntity t set t.status='completed' where t.transactionId="+transactionEntity.getTransactionId());	
		
			messageAboutOrderStatus.append("Your transaction got completed at "+transactionEntity.getTransactionDate().getTime()+"\n");
			
			orderHeaderEntity.setAddress(customerEntity.getCustomerName()+"\n"+customerEntity.getAddressLine1()+", "+customerEntity.getAddressLine2()+", "+customerEntity.getCity()+", "+customerEntity.getState()+", "+customerEntity.getPinCode()+"\n Mob No:"+customerEntity.getPhone());
			orderHeaderEntity.setCustomer(customerEntity);
			orderHeaderEntity.setDeliveryDate(Calendar.getInstance());
			orderHeaderEntity.setOrderDate(Calendar.getInstance());
			orderHeaderEntity.setStatus("Initial");
			orderHeaderEntity.setTotalAmont(transactionEntity.getAmount());
			orderHeaderEntity.setTransaction(transactionEntity);
			
			em.persist(orderHeaderEntity);

			messageAboutOrderStatus.append("\nYour Order is being processed by our team at "+orderHeaderEntity.getOrderDate().getTime()+"\n");
			
			orderDetailsEntity.setOrderHeader(orderHeaderEntity);
			orderDetailsEntity.setProduct(productEntity);
			orderDetailsEntity.setQuantity(1);
			orderDetailsEntity.setTotalPrice(transactionEntity.getAmount());
			
			em.persist(orderDetailsEntity);
			
			Query query = em.createQuery("Update OrderHeaderEntity o set o.status='approved' where o.OrderHeaderId="+orderHeaderEntity.getOrderHeaderId());
			query.executeUpdate();
			messageAboutOrderStatus.append("Your Order is placed at"+Calendar.getInstance().getTime());
			
			return messageAboutOrderStatus.toString();
		}
		
		public OrderDetails getOrderDetails(Integer orderHeaderId) {
			System.out.println("In DAO, orderHeaderId: "+orderHeaderId);
			OrderHeaderEntity orderHeaderEntity = em.find(OrderHeaderEntity.class, orderHeaderId);
			
			Query query = em.createQuery("select o from OrderDetailsEntity o where o.orderHeader=:orderHeader ");
			query.setParameter("orderHeader", orderHeaderEntity);
			OrderDetailsEntity orderDetailsEntity = (OrderDetailsEntity) query.getSingleResult();
			OrderDetails orderDetailsBean = new OrderDetails();
			orderDetailsBean.setProductId(orderDetailsEntity.getProduct().getProductId());
			orderDetailsBean.setQuantity(orderDetailsEntity.getQuantity());
			orderDetailsBean.setTotalPrice(orderDetailsEntity.getTotalPrice());
			orderDetailsBean.setUnitPrice(orderDetailsEntity.getProduct().getPrice());
			
			return orderDetailsBean;
		}
		
		public OrderHeader getOrderHeader(Integer orderHeaderId) {
			
			OrderHeader orderHeader = new OrderHeader();
			OrderHeaderEntity orderHeaderEntity = em.find(OrderHeaderEntity.class,orderHeaderId);
			 
			orderHeader.setCustomerFullName(orderHeaderEntity.getCustomer().getCustomerName());
			orderHeader.setCustomerUsername(orderHeaderEntity.getCustomer().getUsername());
			orderHeader.setDeliveryDate(orderHeaderEntity.getDeliveryDate().getTime().toString());
			orderHeader.setOrderDate(orderHeaderEntity.getOrderDate().getTime().toString());
			orderHeader.setOrderHeaderId(orderHeaderEntity.getOrderHeaderId());
			orderHeader.setShipmentAddress(orderHeaderEntity.getAddress());
			orderHeader.setStatus(orderHeaderEntity.getStatus());
			orderHeader.setTotalAmount(orderHeaderEntity.getTotalAmont());
			orderHeader.setTransactionId(orderHeaderEntity.getTransaction().getTransactionId());
			
			return orderHeader;
		}
}
