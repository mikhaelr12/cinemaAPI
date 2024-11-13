// app.js
document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault();  // Prevent the default form submission

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Prepare the data to be sent to the backend
    const userData = {
        username: username,
        password: password
    };

    // Make the POST request to the /auth/register endpoint
    fetch('/auth/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(userData),  // Send the data as JSON
    })
        .then(response => {
            if (!response.ok) {
                return response.json().then(errorData => {
                    throw new Error(errorData.message || 'Registration failed');
                });
            }
            return response.json();
        })
        .then(data => {
            // Handle successful registration
            alert('Registration successful!');
            console.log(data); // You can log the response for further debugging
            // Optionally, redirect to login page or another page after successful registration
            window.location.href = '/login'; // Redirect to login page
        })
        .catch(error => {
            // Handle error response
            alert('Error: ' + error.message);
        });
});
