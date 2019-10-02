<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/CSS/main.css" />
</head>
<body>
		<div align="left">
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
		<h2>Customer Home Page</h2>
		${MESSAGE}
		<h3>Welcome to the portal</h3>
		<div class="containerForTwoProductRows">
		<div class="containerForProducts">
			<jstl:forEach items="${productList}" var="item">
				<div class="containerForEachProduct">
				<div>
				<h3><a href="getProductPage.vin?productId=${item.productId}"> ${item.productName}</a></h3><br>
				From: ${item.company }<br />
				Price: ${item.price } <br>
				Offer: ${item.offer }<br/>
				</div>
				<div>
					
						<img src=${item.productUrl} height="100px" width="100px" />
					
				</div>
				Rating: ${item.rating }
			</div>
			<hr />
				
				
			</jstl:forEach>
			
			<!-- <div class="containerForEachProduct">
				<div>
				Product Name: Oneplus 6T<br>
				Price: Rs. 34000/- <br>
				Company: OnePlus <br>
				</div>
				<div>
						<img src="./resources/images/oneplus 6t.jpeg" height="100px" width="100px" />
					
				</div>
				<div>
				<button>Add to kart</button>
				</div>
				<div>
				<button> Buy Now</button>
				</div>
			</div>
			<hr />
			<div class="containerForEachProduct">
					Product Name: P1<br>
				Price: $100 <br>
				Company: C1 <br>
			</div>
			<hr />
				<div class="containerForEachProduct">
					Product Name: P1<br>
				Price: $100 <br>
				Company: C1 <br>
			</div>
			<hr />
			<div class="containerForEachProduct">
					Product Name: P1<br>
				Price: $100 <br>
				Company: C1 <br>
			</div>
			<hr />
			<div class="containerForEachProduct">
				<div>
				Product Name: P1<br>
				Price: $100 <br>
				Company: C1 <br>
				</div>
				<div>
					<img src="./resources/images/backgroundImage.jpg" height="50px" width="40px" />
				</div>
			</div>
			<hr />
				<div class="containerForEachProduct">
				<div>
				Product Name: P1<br>
				Price: $100 <br>
				Company: C1 <br>
				</div>
				<div>
					<img src="./resources/images/backgroundImage.jpg" height="50px" width="40px" />
				</div>
			</div>
			<hr />
				<div class="containerForEachProduct">
				<div>
				Product Name: P1<br>
				Price: $100 <br>
				Company: C1 <br>
				</div>
				<div>
					<img src="./resources/images/backgroundImage.jpg" height="50px" width="40px" />
				</div>
				</div>
				<hr />
				<div class="containerForEachProduct">
				<div>
				Product Name: P1<br>
				Price: $100 <br>
				Company: C1 <br>
				</div>
				<div>
					<img src="./resources/images/backgroundImage.jpg" height="50px" width="40px" />
				</div>
			</div>
				<hr />
		</div>
		<div class="containerForProducts">
			<div class="containerForEachProduct">
				<div>
				Product Name: P1<br>
				Price: $100 <br>
				Company: C1 <br>
				</div>
				<div>
					<img src="./resources/images/backgroundImage.jpg" height="50px" width="40px" />
				</div>
			</div>
			<hr />
			<div class="containerForEachProduct">
					Product Name: P1<br>
				Price: $100 <br>
				Company: C1 <br>
			</div>
			<hr />
				<div class="containerForEachProduct">
					Product Name: P1<br>
				Price: $100 <br>
				Company: C1 <br>
			</div>
			<hr />
			<div class="containerForEachProduct">
					Product Name: P1<br>
				Price: $100 <br>
				Company: C1 <br>
			</div>
			<hr />
			<div class="containerForEachProduct">
				<div>
				Product Name: P1<br>
				Price: $100 <br>
				Company: C1 <br>
				</div>
				<div>
					<img src="./resources/images/backgroundImage.jpg" height="50px" width="40px" />
				</div>
			</div>
			<hr />
				<div class="containerForEachProduct">
				<div>
				Product Name: P1<br>
				Price: $100 <br>
				Company: C1 <br>
				</div>
				<div>
					<img src="./resources/images/backgroundImage.jpg" height="50px" width="40px" />
				</div>
			</div>
			<hr />
				<div class="containerForEachProduct">
				<div>
				Product Name: P1<br>
				Price: $100 <br>
				Company: C1 <br>
				</div>
				<div>
					<img src="./resources/images/backgroundImage.jpg" height="50px" width="40px" />
				</div>
				</div>
				<hr />
				<div class="containerForEachProduct">
				<div>
				Product Name: P1<br>
				Price: $100 <br>
				Company: C1 <br>
				</div>
				<div>
					<img src="./resources/images/backgroundImage.jpg" height="50px" width="40px" />
				</div>
			</div>
				<hr />
	 -->	</div>
		</div>
	</div>
	
</body>
</html>