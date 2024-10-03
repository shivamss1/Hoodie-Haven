let loginform = document.getElementById("loginform");

loginform.addEventListener("submit", async function (e) {
    e.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
  let response=  await fetch("http://localhost:8080/login", {
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
      },
      method: "POST",
      body: new URLSearchParams({
        username: username,
        password: password,
    })
  })
    if (response.ok) {
        handleLogin();
    } else {
        alert('Login failed! Please check your credentials.');
    }
    console.log(response);
});

function handleLogin() {
    // After successful login, set authentication status
    localStorage.setItem('isAuthenticated', 'true'); // Mark user as authenticated
    window.location.href = '../Web-pages/adminpanel.html'; // Redirect after login
}