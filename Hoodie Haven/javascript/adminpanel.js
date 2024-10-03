document.addEventListener('DOMContentLoaded',function () {

const AddProductTab = document.getElementById("AddProductTab");
const GetProductsTab = document.getElementById("GetProductsTab");
const GetContactTab = document.getElementById("getContactTab");

const addProductContent = document.getElementById("addProductContent");
const getProductContent = document.getElementById("getProductContent");
const getContactContent = document.getElementById("getContactContent");

function showTab(showcontent) {
    addProductContent.classList.remove('show', 'active');
    getProductContent.classList.remove('show', 'active');
    getContactContent.classList.remove('show','active');
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

    GetContactTab.addEventListener('click', function (e) {
        e.preventDefault();
        showTab(getContactContent);
        getcontacts();
    });
})




async function getproducts ()  {
    let tablerow = document.getElementById("tablerow");
    tablerow.innerHTML = "";
    const username = "shreya";
const password = "shreya12";
    const header = new Headers();
header.append('Authorization', 'Basic ' + btoa(username + ':' + password));
    let productdata = await fetch('http://localhost:8080/product/products', {
        headers: header,
        method: 'GET', 
    });
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

async function getcontacts() {
    let tablerow1 = document.getElementById("tablerow1");
    tablerow1.innerHTML = "";
    const username = "shreya";
const password = "shreya12";
    const header = new Headers();
header.append('Authorization', 'Basic ' + btoa(username + ':' + password));
    let contactdata = await fetch('http://localhost:8080/contact/getAllContacts', {
        headers: header,
        method: 'GET', 
    });
    let contacts = await contactdata.json();
    contacts.forEach(contact => {
        tablerow1.innerHTML += `
        <tr class="table-primary">
        <td scope="row">${contact.name}</td>
        <td scope="row">${contact.email}</td>
        <td scope="row">${contact.message}</td>
        </tr>
        `;
    });
}

async function deleteproduct(product_id) {
    const username = "shreya";
    const password = "shreya12";
    const header = new Headers();
    header.append('Authorization', 'Basic ' + btoa(username + ':' + password));
    let response = await fetch(`http://localhost:8080/product/delete-product?id=${product_id}`, {
        method: 'DELETE',
        headers: header,
    });
    if (response.status==204) {
        alert('Product deleted successfully');
        getproducts(); // Refresh the product list after deletion
    } else {
        alert('Failed to delete the product');
    }
}