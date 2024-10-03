const form = document.getElementById("user-register");


form.addEventListener('submit', async function(e){
    e.preventDefault();
    const formdate = new FormData(this);

const data = {
    "username": formdate.get('username'),
    "mailid": formdate.get('email'),
    "password": formdate.get('password'),
    "mobileno": formdate.get('mobileno'),
}

console.log(data);


    let response = await fetch("http://localhost:8080/user/usersignup", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data)
    });

    const txt = await response.text();
    if (response.status==201) {
        alert(txt);
        window.location.href = "http://localhost:5500/Web-pages/Home.html";
    } else {
        alert(txt.toString());
        window.location.href = "http://localhost:5500/Web-pages/Home.html";
    }
})