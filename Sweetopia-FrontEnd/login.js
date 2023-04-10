let loginForm=document.getElementById("loginForm")
console.log("Inside loginjs")
loginForm.addEventListener("submit",(e)=>{
    e.preventDefault();
    let email=document.getElementById("loginname").value;
    let password=document.getElementById("loginpassword").value;
    let role=document.getElementById("loginrole").value;
    if(role=="user"){
        loginCustomer(email,password);
    }else{
        loginAdmin(email,password);
    }
})
async function loginAdmin(email,password){
    let obj={
        userPassword: password,
        email: email
      }
      let res = await fetch("http://localhost:8080/sweetopia/admin/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(obj)
      });

        if(res.ok){
            let data=await res.json();
            localStorage.setItem("admin","true");
            window.location.href="/admin.html";
             
        }else{
            
            let data=await res.json();
            window.alert(data.message)
        }
}



async function loginCustomer(email,password){
    let obj={
        userPassword: password,
        email: email
      }
      let res = await fetch("http://localhost:8080/sweetopia/customers/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(obj)
      });

        if(res.ok){
            let data=await res.json();
            localStorage.setItem("user",JSON.stringify(data));
            console.log(data)
            

             window.location.href="/product.html";
        }else{
            let data=await res.json();
            window.alert(data.message)
        }
}