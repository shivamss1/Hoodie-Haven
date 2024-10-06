let CartDiv = document.querySelector("#cart-container");
let  carttotal = document.querySelector("#total");
let tally=document.getElementById("tally");

  var productLength;
  const userId = localStorage.getItem('userId');
  console.log(userId);


let displayProduct = async () => {
    CartDiv.innerHTML = "";
    carttotal.innerHTML="";
    
    let allproduct = await fetch(`http://localhost:8080/getcart?userid=${userId}`);
    let products = await allproduct.json();
    console.log(products);
     productLength=products.length;

    console.log(productLength);
   
    total=0;
   
    products.forEach(cartItem => { 
          
        let product = cartItem.product;


        CartDiv.innerHTML +=`
        
       <div class="product-details">
            <img src=src="${product.mainimage}" class="product-image">
            <h1 class="product-name">${product.title}</h1>
            <p class="product-description">"${product.description}"</p>
            <span class="price">${product.price}</span>
    
            <form class="add-to-cart-form">
                <label for="quantity">Quantity:</label>
                <input type="number" id="quantity" onchange="updateTotal(${product.price},${cartItem.cartId})" name="quantity" min="1" value="1">
            </form>
           <div class="button">
            <button class="continue-shopping">Continue Shopping</button>
            <button class="checkout-button">Proceed to Checkout</button>
            <button class="remove-button"  data-cart-id="${cartItem.cartId}">Romove-Product</button>
           </div>
        </div>`;
       total+=product.price;
})
products.forEach(item =>{
    let product=item.product;
    console.log(product);
    carttotal.innerHTML+=`<div class="productPrice">
               <h2>${product.title}</h2>
               <h2>$${product.price}</h2>
            </div>

            `
})

tally.innerHTML=`
    <h2>Total Amount</h2>
    <h2>$${total}</h2>`

removefromcart();

 
  
 

        
};
function updateTotal() {
    total = 0;
    let quantityInputs = document.querySelectorAll("#quantity");
    carttotal.innerHTML="";
    quantityInputs.forEach(input => {
        let quantity = parseInt(input.value);
        console.log(quantity);
        let priceText= input.closest('.product-details').querySelector('.price').textContent.replace('$', '');
        console.log(priceText)
        total += priceText * quantity; 
        let productTitle = input.closest('.product-details').querySelector('.product-name').textContent;
    console.log(productTitle);
        carttotal.innerHTML += `
            <div class="productPrice">
                <h2>${productTitle}</h2>
                <h2>$${(priceText * quantity).toFixed(2)}</h2>
            </div>`;
    });
    

    tally.innerHTML = `
        <h2>Total Amount</h2>
        <h2>$${total}</h2>`; 
}

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