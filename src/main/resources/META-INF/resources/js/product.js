/**
 * javascript for loading product data
 **/
function loadProducts() {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'http://localhost:8080/products', true);
	xhr.send();
	xhr.onload = () => {

		if (xhr.status == 200) {
			displayProducts(JSON.parse(xhr.responseText));
		}
	}

};
var interval = 1000 * 60 ; // interval of one minute

setInterval(updatePrice(), interval);

function updatePrice() {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'http://localhost:8080/updateprice', true);
	xhr.send();
	xhr.onload = () => {

		if (xhr.status == 200) {
			displayProducts(JSON.parse(xhr.responseText));
		}
	}

};

let displayProducts = (products) => {
	console.log(products);
	let productTable = '';
	productTable = `<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">NAME</th>
		      <th scope="col">PRICE</th>
		    </tr>
		  </thead>
		  <tbody>
		    `;
	products.forEach(function(product) {
		productTable += '<tr><td>' + product.id + '</td><td>' + product.name + '</td><td>' + product.price + '</td></tr>';
	});
	productTable += `</tbody>
		</table>`;

	document.querySelector("#products-tab").innerHTML = productTable;

};