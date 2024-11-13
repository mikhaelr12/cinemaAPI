const API_URL = 'http://localhost:8080/auth/login'; // The login API URL

// Handles the login request
async function login(username, password) {
    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ username, password }),
        });

        if (response.ok) {
            // Assuming token is returned in JSON format
            const data = await response.json();
            const token = data.token; // Get token from response

            // Store the token and user in localStorage
            localStorage.setItem('user', username);
            localStorage.setItem('token', token);
            localStorage.setItem('expiresIn', data.expiresIn); // Optionally store expiry time

            // Redirect to the protected page (index.html or the requested page)
            window.location.href = localStorage.getItem('returnUrl') || '/index.html'; // Using returnUrl if exists
        } else {
            // Show error if login fails
            const errorData = await response.json();
            showError(errorData?.message || 'Invalid credentials');
        }
    } catch (error) {
        // Handle any unexpected error
        showError('An error occurred during login. Please try again.');
    }
}

// Display error message
function showError(message) {
    const errorMessageElement = document.getElementById('error-message');
    if (errorMessageElement) {
        errorMessageElement.textContent = message;
        errorMessageElement.style.display = 'block';
    }
}

// Event listener for form submission
document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent default form submission

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Call the login function
    login(username, password);
});

// Store the current URL to return after login (if applicable)
if (!localStorage.getItem('returnUrl')) {
    localStorage.setItem('returnUrl', window.location.pathname);
}
