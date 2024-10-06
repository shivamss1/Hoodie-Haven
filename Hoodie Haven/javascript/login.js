document.getElementById('submit').addEventListener('click', function (event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    
    fetch(`http://localhost:8080/userlogin?username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Invalid credentials');
        }
        return response.text(); 
    })
    .then(data => {
        console.log(data); 
        
        
        const userIdMatch = data.match(/User ID:\s*(\d+)/);
        if (userIdMatch) {
            const userId = userIdMatch[1]; 
            localStorage.setItem('userId', userId); 
            
           
        } else {
            alert('Error retrieving userId');
        }
    })
    .catch(error => {
        alert('Login failed: ' + error.message);
    });
});
