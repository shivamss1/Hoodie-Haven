const urlParams = new URLSearchParams(window.location.search);
const product_id = urlParams.get("id");
console.log(product_id);

let product_detail = async () => {
    const response = await fetch(`http://localhost:8080/product?id=${product_id}`);
    const product_data = await response.json();
    let product = document.querySelector("");
    product.innerHTML += `   
      
        `;
} 

window.onload =product_detail;