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
    });
})
