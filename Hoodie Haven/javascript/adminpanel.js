document.addEventListener('DOMContentLoaded',function () {

    const AddProductTab = document.getElementById("AddProductTab");
const GetProductsTab = document.getElementById("GetProductsTab");

const addProductContent = document.getElementById("addProductContent");
const getProductContent = document.getElementById("getProductContent");

function showTab(showcontent) {
    addProductContent.classList.remove('show', 'active');
    getProductContent.classList.remove('show', 'active');
    showcontent.classList.add('show','active');
}


    AddProductTab.addEventListener('click', function (e) {
        e.preventDefault();
        showTab(addProductContent);
    });
    
    GetProductsTab.addEventListener('click', function (e) {
        e.preventDefault();
        showTab(getProductContent);
        getproducts();
    });
})

async function getproducts ()  {
    let tablerow = document.getElementById("tablerow");
    tablerow.innerHTML = "";
    let productdata = await fetch('http://localhost:8080/products');
        let products = await productdata.json();
    products.forEach(product => {
        tablerow.innerHTML += `
         <tr class="table-primary">
        <td scope="row">${product.p_id}</td>
        <td scope="row"><img src="data:image/jpeg;base64,${product.mainimage}" style="height:200px; width:200px;"></img></td>
        <td scope="row">${product.title}</td>
        <td scope="row">${product.description}</td>
        <td scope="row">${product.price}</td>
        <td scope="row">${product.size}</td>
        <td scope="row">${product.stock}</td>
        <td><input type="button" value="Edit" id="editproduct" onclick=""></td>
        <td><input type="button" value="Delete" id="deleteproduct" onclick="deleteproduct(${ product.p_id })"></td>
                                    </tr>`;    
    });
    
    
}

async function deleteproduct(product_id) {
    let response = await fetch(`http://localhost:8080/delete-product?id=${product_id}`, {
        method: 'DELETE',
    });
    if (response.ok) {
        alert('Product deleted successfully');
        getproducts(); // Refresh the product list after deletion
    } else {
        alert('Failed to delete the product');
    }
}