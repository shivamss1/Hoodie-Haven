let productDiv = document.querySelector(".products");
const userId = localStorage.getItem('userId');
let displayProduct = async () => {
    updatecarticon();
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
let displayProductByCategory = async (category) => {
    updatecarticon();
    let categoryParam = category;
    productDiv.innerHTML = ""; // Clear existing products
    let categoryApi = `http://localhost:8080/category?category=${categoryParam}`; // Replace with your category API

    let response = await fetch(categoryApi);
    let products = await response.json();
    
    console.log(products);
    products.forEach(element => { 
        productDiv.innerHTML +=`
        <div class="product-card">
                <a href="../Web-pages/product_detail.html?id=${element.id}">
                    <img src="${element.mainimage}" alt="Product 3">
                </a>
                <h3>${element.title}</h3>
                <p>$ ${element.price}</p>
                <button class="btn add-to-cart" data-cart-id="${element.id}">Add to Cart</button>
                <button class="btn buy-now">Buy Now</button>
            </div>`;
    });
    addtocart();
};

let addtocart= () => {
    let addtocart = document.querySelectorAll('.btn.add-to-cart');

    addtocart.forEach(button => {
        button.addEventListener('click', async (event) => {
            let productId = event.target.getAttribute('data-cart-id'); 

            let response = await fetch(`http://localhost:8080/addToCart?userId=${userId}&productId=${productId}`, {
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
let cartitemno=document.getElementById("cartItemno");


async function updatecarticon (){
  let allproduct = await  fetch(`http://localhost:8080/getcart?userid=${userId}`);
  let products = await allproduct.json();
   productLength=products.length;
  console.log(productLength);
   cartitemno.innerHTML=`<h2 >${productLength}</h2>`
  
} 
let handleCategoryChange = () => {
    let selectedCategories = [];
    const checkboxes = document.querySelectorAll('input[name="category"]:checked');
    checkboxes.forEach((checkbox) => {
        selectedCategories.push(checkbox.value);
    });
    
    if (selectedCategories.length > 0) {
        displayProductByCategory(selectedCategories);
    } else {
        displayProduct();
    }
};

let categoryCheckboxes = document.querySelectorAll('input[name="category"]');
categoryCheckboxes.forEach((checkbox) => {
    checkbox.addEventListener('change', handleCategoryChange);
});


window.onload = displayProduct;

