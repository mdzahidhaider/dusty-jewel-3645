// import { showmessage } from "./popupMessage.js";
const baseUrl = "http://localhost:8080/sweetopia";
const userRedirectLink = "./home.html";
const adminRedirectLink = "./admin-panel/admin.html";
const signupForm = document.querySelector(".signup-wrapper form");
signupForm.addEventListener("submit", async (e) => {
  e.preventDefault();
  const inputs = document.querySelectorAll(".signup-wrapper form input"); 
  // const role = document.querySelector("#role").value;
  // const text = role === "user" ? "/customers" : "Admin";
  const text = "/customers";
  console.log(baseUrl + text)
  if(text=="/customers"){
    try {
        const object = {
        userName: inputs[0].value,
        email: inputs[1].value,
        userPassword: inputs[2].value,
      }; 
        const data = await fetch(baseUrl + text, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(object),
        });
        const res = await data.json();
        console.log(res)

        if (res.message) {
          alert(res.message);
        } 
        else {
          alert("Registered Success")
        }
      } catch (error) {
        showmessage("Oops! something went wrong", "red", "fa-xmark");
        console.log(error);
      }
  }
  
});




