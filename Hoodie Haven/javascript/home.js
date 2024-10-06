let cartitemno=document.getElementById("cartItemno");
const userId=localStorage.getItem('userId');


let updatecarticon=async () =>{
  let allproduct = await  fetch(`http://localhost:8080/getcart?userid=${userId}`);
  let products = await allproduct.json();
   productLength=products.length;
  console.log(productLength);
   cartitemno.innerHTML=`<h2 >${productLength}</h2>`
  
} 
window.onload=updatecarticon;

const carousel = document.getElementById('carouselExampleFade');
const carouselInstance = new bootstrap.Carousel(carousel, {
  interval: 2000
});

