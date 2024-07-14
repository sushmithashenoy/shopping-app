<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/mdbootstrap@4.20.0/css/mdb.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/popper@1.0.1/resources/dashboard-results/dashboard-results.min.css">
<link rel="stylesheet" href="css/style.css">

<meta charset="UTF-8">
<title>ERICSSON SHOPPING APP</title>
</head>
<body onload="attachHandlers();loadProducts();">
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/mdbootstrap@4.20.0/js/mdb.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper@1.0.1/index.min.js"></script>
	<script type="text/javascript" src="js/product.js"></script>
	<script type="text/javascript" src="js/cart.js"></script>



	<!-- Header -->
	<nav
		class="header navbar navbar-expand-md navbar-dark bg-dark justify-content-center">
		<a class="navbar-brand abs" href="#">ERICCSON SHOPPING APP</a>
	</nav>

	<!-- Input COntainer -->
	<div class="container mt3 input-container">
		<div
			class="row  height d-flex justify-content-center align-items-center">
<!-- 			<div class="col text-center"> -->
<!-- 				<button class="btn btn-primary" id="product-btn" -->
<!-- 					onclick="loadTable()">LOAD PRODUCTS</button> -->
<!-- 			</div> -->
			<div class="col text-center">
				<button class="btn btn-primary" id="product-btn"
					onclick="updatePrice()">UPDATE PRICE</button>

			</div>

			<div class="col-md-6">

				<div class="search">
					<i class="fa fa-search"></i> <input type="text"
						class="form-control" id="customer-id"
						placeholder="Enter customer id">
				</div>
			</div>
		</div>
	</div>

 	<!-- Data COntainer -->
	<div class="container-fluid mt3">
		<div class="row">
			<div class="col-md-6">
				<div class="card">
					<div class="card-header">
						<h3>PRODUCTS</h3>
					</div>
					<div class="card-body" id="products-tab"></div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="card">
					<div class="card-header">
						<h3>SHOPPING CART</h3>
					</div>
					<div class="card-body" id="cart-tab"></div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>