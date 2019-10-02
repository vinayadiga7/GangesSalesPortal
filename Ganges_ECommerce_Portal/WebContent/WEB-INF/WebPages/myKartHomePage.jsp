<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/CSS/main.css" /> 
</head>
<body>
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
	<div align="center">
	
		<h3>My Kart details</h3>
		<div class="containerMyKartProductColumn">
			<jstl:forEach items="${myKartProductList}" var="myKartProduct">
				<div class="containerMyKartProductRow">
					<div>
						<h3><a href="getProductPage.vin?productId=${myKartProduct.productId }">${myKartProduct.productName }</a></h3>
						From: ${myKartProduct.company}<br>
						Price: ${myKartProduct.price}<br>	
						<div style="color:green">Offer: ${myKartProduct.offer }</div><br>
					</div>
					<div class="containerMyKartProductImage">
						<div><img alt="image not found" src="${myKartProduct.productUrl }" height="100px" width="150px"></div>
						<div><button onclick="location.href='removeProductFromMyKart.vin?kartNumber=${myKartProduct.kartNumber}'">Remove</button></div>
						<div><button onclick="location.href='byProductNow.vin?productId=${myKartProduct.productId}&kartNumber=${myKartProduct.kartNumber}'">Buy Now</button></div>
					</div>
				</div>
			</jstl:forEach>
		</div>
	</div>
</body>
</html>