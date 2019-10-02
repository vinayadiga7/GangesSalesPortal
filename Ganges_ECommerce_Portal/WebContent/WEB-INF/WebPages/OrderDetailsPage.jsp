<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
			<div class="containerForEachOrder">
				<div style="font-size: 20px;">
					<div>Order ID: ${orderHeader.orderHeaderId }</div>
					<div><a style="color: green;" href="getProductPage.vin?productId=${product.productId}">Item Ordered: ${product.productName }</a></div>
					<div>Unit Price: ${orderDetails.unitPrice }</div>
					<div>Quantity Ordered: ${orderDetails.quantity}</div>
					<div>Order Date: ${orderHeader.orderDate}</div>
					<div>Your Order will be delivered on or before: ${orderHeader.deliveryDate}</div>
					<div>Total Amount: ${orderHeader.totalAmount }</div>
					<div>Order Status: ${orderHeader.status }</div>
					<div>Shipment Address: ${orderHeader.shipmentAddress }</div>
				</div>
				<div>
					<img src="${product.productUrl}" height="200px" width="300px"/>
					
				</div>
			</div>
	</div>
</body>
</html>