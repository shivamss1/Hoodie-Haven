let productDiv = document.querySelector(".products");
let displayProduct = async () => {
    productDiv.innerHTML = "";
    let allproduct = await fetch("http://localhost:8080/products");
    let products = await allproduct.json();
    console.log(products);
    products.forEach(element => { 
        console.log(element.id);
        productDiv.innerHTML +=`
        <div class="product-card">
                <a href="../Web-pages/product_detail.html?id=${element.id}">
                    <img src="${element.mainimage}" alt="Product 3">
                </a>
                <h3>${element.title}</h3>
                <p>$ ${element.price}</p>
                <button class="btn add-to-cart" data-cart-id="${element.id}">Add to Cart</button>
                <button class="btn buy-now">Buy Now</button>
            </div>`
    });
    addtocart();
}


let addtocart= () => {
    let addtocart = document.querySelectorAll('.btn.add-to-cart');

    addtocart.forEach(button => {
        button.addEventListener('click', async (event) => {
            let productId = event.target.getAttribute('data-cart-id'); 

            let response = await fetch(`http://localhost:8080/addToCart?productId=${productId}`, {
                method: 'POST'
            });

            if (response.ok) {
                console.log(`Cart item with ID ${productId} added successfully`);
               // displayProduct();
            } else {
                console.error(`Failed to remove product with cartId: ${productId}`);
            }
        });
    });
};
window.onload = displayProduct;

