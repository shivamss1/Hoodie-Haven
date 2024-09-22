document.getElementById('buynow-form').addEventListener("submit", async function (event) {
    event.preventDefault(); 

    const formdata = {
        name: document.getElementById('name').value,
        email: document.getElementById('email').value,
        phoneno: document.getElementById('phone').value,
        address: document.getElementById('Address').value
    };

    let data= await fetch('http://localhost:8080/savedata', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(formdata)
    })
    
    if(data.ok){
      console.log(data.text());
    }
    else{
        console.log("not submitted");
    }
});
