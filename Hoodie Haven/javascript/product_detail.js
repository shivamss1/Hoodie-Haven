const urlParams = new URLSearchParams(window.location.search);
const product_id = urlParams.get("id");
console.log(product_id);

let product_detail = async () => {
    const response = await fetch(`http://localhost:8080/product?id=${product_id}`);
    const product_data = await response.json();
    let product = document.querySelector(".product_detail");
    product.innerHTML = `   
        <div class="main-image">
            <img src="${product_data.image}" alt="">
        </div>
        <div class="extra_image">
            <img src="../Img/HH-logo.png" alt="image 1">
            <img src="../Img/HH-logo.png" alt="image2">
            <img src="../Img/HH-logo.png" alt="image3">
            <img src="../Img/HH-logo.png" alt="image4">
        </div>
        <h2 id="title">${product_data.title}</h2>
        <div class="cont1">
            <div>
                <h4 id="price">$ ${product_data.price}</h4>
            </div>
            <div class="size-selection">
                <label for="size">Size:</label>
                <select id="size" class="form-control">
                    <option value="s">S</option>
                    <option value="m">M</option>
                    <option value="l">L</option>
                    <option value="xl">XL</option>
                    <option value="xxl">XXL</option>
                </select>
            </div>
            
            <div class="quantity-container">
                <button class="quantity-button" id="decrease">-</button>
                <input type="number" id="quantity" value="1" min="1">
                <button class="quantity-button" id="increase">+</button>
            </div>
        </div>
        
        <p>${product_data.description}</p>
        <div id="button-container">
            <button>Add-to-cart</button>
            <button>Buy Now</button>
        </div>`;
} 

window.onload =product_detail;