let productDiv = document.querySelector(".products");
let displayProduct = async () => {
    productDiv.innerHTML = "";
    let allproduct = await fetch("http://localhost:8080/product/products");
    let products = await allproduct.json();
    console.log(products);
    products.forEach(element => { 
        console.log(element.p_id);
        productDiv.innerHTML +=`
        <div class="product-card">
                <a href="../Web-pages/product_detail.html?id=${element.id}">
                    <img src="data:image/jpeg;base64,${element.mainimage}" alt="Product 3">
                </a>
                <h3>${element.title}</h3>
                <p>$ ${element.price}</p>
                <button class="btn add-to-cart">Add to Cart</button>
                <button class="btn buy-now">Buy Now</button>
            </div>`
    })
}

window.onload = displayProduct;

