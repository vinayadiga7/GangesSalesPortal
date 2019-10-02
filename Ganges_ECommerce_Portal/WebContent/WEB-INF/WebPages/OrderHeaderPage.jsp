<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="order" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/CSS/main.css" />
</head>
<body>
	<div align="center">
			<div class="container">
				
						<div >
							<a href="#">Home</a>
						</div>
					
						<div><a href="getListOfProducts.vin">Products</a></div>
					
						<div><a href="getMyKart.vin">MyKart</a></div>
						<div class="home"><a href="getMyOrders.vin">MyOrders</a></div>
						<div align="right">${user}</div>
						<div ><a href="makeMeLogout.vin">LogOut</a></div>
						
						
				
			</div>
			<div class = "containerForOrders">
				<order:forEach items="${orderList }" var="orderItem">
					<div class="containerForEachOrder">
						<div> 
							<div>Order ID: <a href="getOrderDetailsPage.vin?orderHeaderId=${orderItem.orderHeaderId}">O2019${orderItem.orderHeaderId } </a></div>
							<div>Transaction ID: ${orderItem.transactionId }</div>
							<div>Total Amount: ${orderItem.totalAmount }</div>
							<div>OrderDate: ${orderItem.orderDate }</div>
						</div>
						<div>
						
						</div>
					</div>
				</order:forEach>
			</div>
</body>
</html>