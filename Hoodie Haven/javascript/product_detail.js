const urlParams = new URLSearchParams(window.location.search);
const product_id = urlParams.get("id");
console.log(product_id);

let product_detail = async () => {
    const response = await fetch(`http://localhost:8080/product?id=${product_id}`);
    const product_data = await response.json();
    let product = document.querySelector(".product_detail");
    product.innerHTML = `   

                        <div class="col-lg-5 col-md-6 mb-4">
                    <div class="main-image">
                        <img src="data:image/jpeg;base64,${product_data.mainimage}" alt="Main Product Image" class="img-fluid">
                    </div>
                    <div class="extra_image mt-3">
                        <img src="${product_data.extraimage[0]}" alt="image 1" class="img-thumbnail">
                        <img src="data:image/jpeg;base64,${product_data.extraimage[1]}" alt="image 2" class="img-thumbnail">
                        <img src="data:image/jpeg;base64,${product_data.extraimage[2]}" alt="image 3" class="img-thumbnail">
                        <img src="data:image/jpeg;base64,${product_data.extraimage[3]}" class="img-thumbnail">
                    </div>

         
        <div class="info">
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
                <button id="addtocart">Add-to-cart</button>
                <button id="buynow">Buy Now</button>
            </div>
    
        </div>
        `;
} 

window.onload =product_detail;