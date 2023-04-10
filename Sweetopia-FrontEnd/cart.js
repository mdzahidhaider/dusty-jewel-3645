// Get the cart items
const cartItems = document.querySelectorAll('.cart-item');
let cartContainer=document.getElementById("cardAppend");
let totalprice=document.getElementById("total-price")
let user=JSON.parse(localStorage.getItem("user")) || null;
if(user==null){
    window.location.href="/product.html"
}
getCart()
async function getCart(){
    let res = await fetch("http://localhost:8080/sweetopia/carts/"+user.cart.cartId);
    let data= await res.json();
    console.log(data)
    totalprice.innerHTML="Cart Total: "+data.grandTotal+" Rs";
    displayCart(data.listProduct);
}

function displayCart(data){
    cartContainer.innerHTML="";
    if(data.length==0){
        cartContainer.innerHTML="No item in cart";
    }
    
    
    
    data.forEach(ele => {
        cartContainer.innerHTML+=`<div class="products">
        <img data-id=${ele.productId} src=${ele.photoPath}>
        <h3>${ele.name}</h3>
        <p>${ele.description}</p>
        <p class="price">price: ${ele.price} Rs</p>
        <p class="price">qunatity: ${ele.quantity}</p>
        </div>`;
    });


}
getCartForBadge()

async function getCartForBadge(){
    let res = await fetch("http://localhost:8080/sweetopia/carts/"+user.cart.cartId);
    let data= await res.json();
    if(res.ok){
        let badge=document.getElementById("badge").innerHTML=data.productCount;
    }else{
        let badge=document.getElementById("badge").innerHTML=0;
    }
    
}
let cartcheck=document.getElementById("cart-checkout");

cartcheck.addEventListener("click",()=>{
    addOrder(user.id);
})

async function addOrder(customerId){
    let res=await fetch(`http://localhost:8080/sweetopia/orders/${customerId}/order`,{
        method:"POST"
    })
    if(res.ok){
        alert("Order created successfully")
        getCart();
    }else{
        alert("Something went wrong")
    }
}