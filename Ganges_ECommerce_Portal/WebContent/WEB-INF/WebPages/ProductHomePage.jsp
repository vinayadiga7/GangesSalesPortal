<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/CSS/main.css">
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
		
		<h3>Product Details Page</h3>
		<div class="containerForProductDetailsRow">
			<div class="containerForProductDetailsColumnForContent">
				<div align="center"><h3>${productSelected.productName }</h3></div>
				<div align="center">From ${productSelected.company }</div>
				<div align="center">Price: ${productSelected.price }</div>
				<div align="center" style="color:green">Offer: ${productSelected.offer } %</div>	
				<div align="center"><b>Product Details</b><br>
					${productSelected.productDetails}
				</div>
			</div>
			<div class="containerForProductDetailsColumnForImage">
				<div align="center">${productSelected.description}</div>
				<div><img alt="image will be loaded" src="${productSelected.productUrl}" height="300px" width="400px"></div>
				<div align="center"><button onclick="location.href='addProductToKart.vin?productId=${productSelected.productId}'">Add to kart</button></div>
				<div align="center"><button  onclick="location.href='byProductNow.vin?productId=${productSelected.productId}'">Buy Now</button></div>
			</div>
			
		</div>
		</div>
</body>
</html>