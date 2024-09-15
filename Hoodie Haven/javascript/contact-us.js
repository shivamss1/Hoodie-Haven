let contactform = document.getElementById("contact-form");

contactform.addEventListener('submit', async function(e) {
    e.preventDefault();
    const formData = new FormData(this);

    const urlencodeddata = new URLSearchParams(formData).toString();

    try {
        const response = await fetch("http://localhost:8080/contact", {
            method: "POST",
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body:urlencodeddata
        })
        if (response.ok) {
            const msg= await response.text();
            window.location.href = "http://localhost:5500/Web-pages/contactus.html";
            alert(msg);
        } else {
            alert("There was error submitting the form.");
        }
    } catch (error) {
        alert(error.message);
    }
})