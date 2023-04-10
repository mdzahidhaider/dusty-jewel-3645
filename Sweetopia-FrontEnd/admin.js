let box=document.getElementById("box");
let text=document.getElementById("operation-text");
let options=document.querySelectorAll(".admin-operation");
let addProductForm=document.getElementById("addproductbutton");


// console.log(addProductButton)
let baseurl="http://localhost:8080/sweetopia"
getProducts()




options.forEach(a=>{
    a.addEventListener("click",(target)=>{
        
        text.innerHTML=a.innerHTML
        box.innerHTML="";
        if(a.innerHTML.toLowerCase()=="products"){
            // addProductButton.classList.remove("none");
            
            getProducts();
        }else if(a.innerHTML=="Categories"){
            getCatgories();
        }else if(a.innerHTML=="Orders"){
            getOrders();
        }
    })
    
    
})

async function getOrders(){
    let url=baseurl+"/orders/orders";
    let res= await fetch(url);
    if(res.ok){
        let data=await res.json();
        data=data.filter(e=>{return e.orderBill==null})
        displayOrder(data)
    }else{
        displayOrder([])
        
        
     }
}
function displayOrder(data){
    box.innerHTML="";
    for(let p of data){
        let inertext=` <div data-id=${p.orderId} id="content">
        <input data-id=${p.orderId} class="orderDate orderDate${p.orderId}" type="text"  disabled value="Order Id: ${p.orderId}">
        <input data-id=${p.orderId} class="orderDate orderDate${p.orderId}" type="text"  disabled value="Date: ${p.createdDate}">
        <input data-id=${p.orderId} class="orderDate orderDate${p.orderId}" type="text"  disabled value="Total products: ${p.groupedProducts.length}">
        <span>mark completed:</span>
        <i data-id=${p.orderId} class="fa-solid fa-check orderDone"></i>
    </div>`
        box.innerHTML+=inertext
    }
    let AllOrderBill=document.querySelectorAll(".orderDone");
    AllOrderBill.forEach((g)=>{
        
        g.addEventListener("click",async function(){
           
             let res=await fetch(baseurl+"/orderbill/"+g.dataset.id+"/orderbill",{
                method:"POST"
             })
             if(res.ok){
                getOrders()
             }else{
                let data = await res.json();
                window.alert(data.message)
             }

        })
    })

}
async function getCatgories(){
    let url=baseurl+"/categories";
    let res= await fetch(url);
    if(res.ok){
        let data=await res.json();
        displayCategory(data);
    }else{
        let data = await res.json();
        window.alert(data.message)
     }
}

async function displaySelectCategory(v){
    let text=`<option value=0>${v}</option>`;
    let url=baseurl+"/categories";
    let res= await fetch(url);
    if(res.ok){
        let data=await res.json();
       data.forEach((e)=>{
        text+=`<option value=${e.categoryId}>${e.categoryName}</option>`
       })
       text+=`<option value="-1">All Products</option>`
    }else{
        let data = await res.json();
        window.alert(data.message)
     }
     return text;

}
function displayCategory(data){
    
    box.innerHTML="";
    for(let p of data){
        let inertext=` <div data-id=${p.categoryId} id="content">
        <img data-id=${p.categoryId} class="categoryImage" src=${p.categoryImage} >
        <input data-id=${p.categoryId} class="categoryName categoryName${p.categoryId}" type="text"  disabled value="${p.categoryName}">
        <i data-id=${p.categoryId} class="fa-solid fa-pen-to-square categoryEdit"></i>
        <i data-id=${p.categoryId} class="fa-solid fa-trash categorydelete"></i>
    </div>`
        box.innerHTML+=inertext
    }
    let edit=document.querySelectorAll(".categoryEdit");
    edit.forEach((e)=>{
        e.addEventListener("click",()=>{
            let id=e.dataset.id;
            let parent=e.parentElement.childNodes;
            console.log(parent)
            parent[3].disabled=false
            
            e.classList.remove("fa-pen-to-square")
            e.classList.add("fa-check")
            let AllSave=document.querySelectorAll(".fa-check");
            AllSave.forEach((fa)=>{
                fa.addEventListener("click",async ()=>{
                    let id=fa.dataset.id;
                    let parent=fa.parentElement.childNodes;
                    parent[3].disabled=true
                    fa.classList.add("fa-pen-to-square")
                    fa.classList.remove("fa-check")
                   let name= document.querySelector(`.categoryName${id}`).value;
                   let res=await fetch(baseurl+`/categories/${id}`)
                   if(res.ok){
                    let data1=await res.json();
                    data1.categoryName=name;
                    
                    const res1 = await fetch(`${baseurl}/categories/${id}`, {
                        method: 'PUT',
                        headers: {
                          'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(data1)
                      });
                    if(res1.ok){
                        getCatgories()
                    }else{
                        let data = await res.json();
                        window.alert(data.message)
                     }
                   }else{
                    let data = await res.json();
                    window.alert(data.message)
                 }
                   
                })
            })
        })})
    let AllDelete=document.querySelectorAll(".fa-trash");
    AllDelete.forEach((g)=>{
        console.log(baseurl+"/categories/"+g.dataset.id)
        g.addEventListener("click",async function(){
           
             let res=await fetch(baseurl+"/categories/"+g.dataset.id,{
                method:"DELETE"
             })
             if(res.ok){
                getCatgories()
             }else{
                let data = await res.json();
                window.alert(data.message)
             }

        })
    })
    
}

async function displayProduct(data,v="All products"){
    
    let d="";
    await displaySelectCategory(v).then((dadata) => {
        d=dadata; 
      }).catch((error) => {
        console.log(error); // handle errors, if any
      });
      
    box.innerHTML=`<div id="productForm" class="none">
    <div id="FormHead"><i id="formheadText">Add Product</i> <i class="fa-solid fa-xmark" id="productCancel"></i></div>
    <form id="productFormac">
        <input type="text" placeholder="product name">
        <input type="text" placeholder="image url">
        <input type="number" placeholder="price">
        <input type="number" placeholder="availability">
        <select name="categories" id="cat-sel-form">${d}</select>
        <input type="submit" value="Add product">
    </form>
</div> <div id="addproductbutton" class="none">Add Product</div><div id=seldiv><select name="categories" id="cat-sel">${d}</select></div>`;
      
      
      
    for(let p of data){
        let inertext=` <div data-id=${p.productId} id="content">
        <img data-id=${p.productId} class="productImage" src=${p.photoPath} >
        <input data-id=${p.productId} class="productName productName${p.productId}" type="text"  disabled value="${p.name}">
        <input data-id=${p.productId} class="productprice productPrice${p.productId}" type="number"  disabled value="${p.price}">
        <input data-id=${p.productId} class="productAvail productAvail${p.productId}" type="number"  disabled value="${p.available}">
        <i data-id=${p.productId} class="fa-solid fa-pen-to-square productEdit"></i>
        <i data-id=${p.productId} class="fa-solid fa-trash productdelete"></i>
    </div>`
        box.innerHTML+=inertext
    }
    let edit=document.querySelectorAll(".productEdit");
    edit.forEach((e)=>{
        e.addEventListener("click",()=>{
            let id=e.dataset.id;
            let parent=e.parentElement.childNodes;
            parent[3].disabled=false
            parent[5].disabled=false
            parent[7].disabled=false
            e.classList.remove("fa-pen-to-square")
            e.classList.add("fa-check")
            let AllSave=document.querySelectorAll(".fa-check");
            AllSave.forEach((fa)=>{
                fa.addEventListener("click",async ()=>{
                    let id=fa.dataset.id;
                    let parent=fa.parentElement.childNodes;
                    parent[3].disabled=true
                    parent[5].disabled=true
                    parent[7].disabled=true
                    fa.classList.add("fa-pen-to-square")
                    fa.classList.remove("fa-check")
                   let name= document.querySelector(`.productName${id}`).value;
                   let price= document.querySelector(`.productPrice${id}`).value;
                   let avail= document.querySelector(`.productAvail${id}`).value;
                   let res=await fetch(baseurl+`/products/${id}`)
                   if(res.ok){
                    let data1=await res.json();
                    data1.name=name;
                    data1.price=price;
                    data1.available=avail;
                    const res1 = await fetch(`${baseurl}/products/${id}`, {
                        method: 'PUT',
                        headers: {
                          'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(data1)
                      });
                    if(res1.ok){
                        getProducts()
                    }else{
                        let data = await res.json();
                        window.alert(data.message)
                     }
                   }else{
                    let data = await res.json();
                    window.alert(data.message)
                 }
                   
                })
            })
        })
        
        
   
    
    })
    let AllDelete=document.querySelectorAll(".fa-trash");
    AllDelete.forEach((g)=>{
        g.addEventListener("click",async function(){
            console.log(baseurl+"/products/"+g.dataset.id)
             let res=await fetch(baseurl+"/products/"+g.dataset.id,{
                method:"DELETE"
             })
             if(res.ok){
                getProducts()
             }else{
                let data = await res.json();
                window.alert(data.message)
             }

        })
    })
    let cat=document.getElementById("cat-sel")
    cat.addEventListener("change",()=>{
        if(cat.value==0 || cat.value==-1){
            getProducts();
        }else{
            const selectedOption = cat.options[cat.selectedIndex];
            
            getProductsByCatId(cat.value,selectedOption.innerHTML);
        }
    })
}
async function getProductsByCatId(id,sel){
    let url=baseurl+`/categories/${id}/products`;
    let res= await fetch(url);
    if(res.ok){
        let data=await res.json();
        
        displayProduct(data,sel);
    }else{
        let data = await res.json();
        window.alert(data.message)
     }
}
async function getProducts(){
    let url=baseurl+"/products";
    let res= await fetch(url);
    if(res.ok){
        let data=await res.json();
        displayProduct(data);
    }else{
        let data = await res.json();
        window.alert(data.message)
     }
}

