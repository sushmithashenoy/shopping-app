/**
 * javascript for loading Shopping cart data
 **/
function attachHandlers() {
	loadCart();
	$("#customer-id").keyup(function() {
		var that = this,
			customerid = $(this).val();
		var url = jQuery.trim(customerid.length) > 0 ? 'http://localhost:8080/customershoppingcart/' + customerid : 'http://localhost:8080/getshoppingcarts';
		loadCart(url);


	});
};
let loadCart = (url='http://localhost:8080/getshoppingcarts') => {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', url, true);
	xhr.send();
	xhr.onload = () => {
		if (xhr.status == 200) {
			displayCart(JSON.parse(xhr.responseText));
		}
	}
};

let displayCart = (cartRows) => {
console.log(cartRows);
	let cartTable = '';
	cartTable = (cartRows.length === 0) ? '<p>Record not found</p>' : `<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">PRODUCT ID</th>
		      <th scope="col">QUANTITY</th>
		      <th scope="col">CUSTOMERID</th>
		      <th scope="col">NAME</th>
		      <th scope="col">PRICE</th>
		    </tr>
		  </thead>
		  <tbody>
		    `;
	cartRows.forEach(function(cartRow) {
		cartTable += '<tr><td>' + cartRow.id + '</td><td>' + cartRow.product.id + '</td><td>' + cartRow.quantity + '</td><td>' + cartRow.customerId + '</td><td>' + cartRow.product.name + '</td><td>' + cartRow.product.price + '</td></tr>';
	});
	cartTable += `</tbody>
		</table>`;

	document.querySelector("#cart-tab").innerHTML = cartTable;

};