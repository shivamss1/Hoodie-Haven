let loginform = document.getElementById("loginform");

loginform.addEventListener("submit", async function (e) {
    e.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
  let response=  await fetch("http://localhost:8080/user/login", {
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
      },
    method: "POST",
      body: new URLSearchParams({
        username: username,
        password: password,
    })
  })
  if (response.ok) {
    let token =  await response.text();
    console.log(token);
    localStorage.setItem('token', token);
    console.log("hi logged in!");
    window.location.href = "../Web-pages/Home.html";
    } else {
        window.alert('Login failed! Please check your credentials.');
    }
    console.log(response);
});


// Function to get a cookie by name
function getCookie(name) {
  const value = `; ${document.cookie}`;
  console.log(value);
  const parts = value.split(`; ${name}=`);
  if (parts.length === 2) return parts.pop().split(';').shift();
}