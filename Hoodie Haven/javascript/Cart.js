let CartDiv = document.querySelector("#cart-container");
let displayProduct = async () => {
    CartDiv.innerHTML = "";
    let allproduct = await fetch("http://localhost:8080/getcart");
    let products = await allproduct.json();
    console.log(products);
    products.forEach(cartItem => { 
        console.log(cartItem.p_id);
        let product = cartItem.product;
        CartDiv.innerHTML +=`
       <div class="product-details">
            <img src=src="${product.mainimage}" class="product-image">
            <h1 class="product-name">"${product.title}"</h1>
            <p class="product-description">"${product.description}"</p>
            <span class="price">"${product.price}"</span>
    
            <form class="add-to-cart-form">
                <label for="quantity">Quantity:</label>
                <input type="number" id="quantity" name="quantity" min="1" value="1">
            </form>
           <div class="button">
            <button class="continue-shopping">Continue Shopping</button>
            <button class="checkout-button">Proceed to Checkout</button>
            <button class="remove-button"  data-cart-id="${cartItem.cartId}">Romove-Product</button>
           </div>
        </div>`
})
removefromcart();
}
;
let removefromcart= () => {
    let removeButtons = document.querySelectorAll('.remove-button');

    removeButtons.forEach(button => {
        button.addEventListener('click', async (event) => {
            let cartId = event.target.getAttribute('data-cart-id'); 

            let response = await fetch(`http://localhost:8080/deletebycartId?cartid=${cartId}`, {
                method: 'DELETE'
            });

            if (response.ok) {
                console.log(`Cart item with ID ${cartId} removed successfully`);
                displayProduct();
            } else {
                console.error(`Failed to remove product with cartId: ${cartId}`);
            }
        });
    });
};


window.onload = displayProduct;