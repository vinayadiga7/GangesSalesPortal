<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/CSS/main.css">
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
			<h2>Payment Gateway: VinPay</h2>
			<div class="containerMyKartProductColumn">
				<div class="containerMyKartProductRow">
					<div>
						<h3><a href="getProductPage.vin?productId=${product.productId }">${product.productName }</a></h3>
						From: ${product.company}<br>
						Price: ${product.price}<br>	
						<jstl:if test="${product.isPromotionalOfferThere == true }">
								<div style="color:green">Promotional Offer: ${product.promotionalOffer }</div><br>
						</jstl:if>
						<jstl:if test="${product.isGangesOfferThere == true }">
								<div>Ganges Special Offer: ${product.gangesOffer }</div><br>						
						</jstl:if>
					</div>
					<div class="containerMyKartProductImage">
						<div><img alt="image not found" src="${product.productUrl }" height="100px" width="150px"></div>
					</div>
				</div>
			
				<form:form action="completeOrder.vin?productId=${product.productId}" modelAttribute="transactionBean">
					<div class="containerForTransaction">
						<table>
							<tr>
								<td>Card Number: </td>
								<td><form:input path="fromAccountCardNumber"/></td>
							</tr>
							<tr>
								<td>Expiry Date: </td>
								<td><form:input path="fromCardExpiryDate"/></td>
							</tr>
							<tr>
								<td>CVV: </td>
								<td><form:input path="fromCardCVV"/></td>
							</tr>
							<tr>
								<td>Amount: </td>
								<td><form:input path="amount" readonly="true"/></td>
							</tr>
							<tr>
								<td><input type="submit" value="Place The Order" /></td>
							</tr>
						</table>
				
					</div>
				</form:form>
				
		
	</div>
</body>
</html>