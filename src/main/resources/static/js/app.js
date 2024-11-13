document.getElementById('loginForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    const user = {
        username: username,
        password: password
    };

    // You can call your backend API for authentication
    fetch('/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
        .then(response => response.json())
        .then(data => {
            if (data.token) {
                alert('Login successful');
                localStorage.setItem('jwtToken', data.token);
            } else {
                alert('Login failed');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('An error occurred');
        });
});
