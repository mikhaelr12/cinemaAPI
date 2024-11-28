const API_URL = 'http://localhost:8080/auth/login';

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
            const data = await response.json();
            const token = data.token;

            localStorage.setItem('user', username);
            localStorage.setItem('token', token);
            localStorage.setItem('expiresIn', data.expiresIn);

            window.location.href = '/index';
        } else {
            const errorData = await response.json();
            showError(errorData?.message || 'Invalid credentials');
        }
    } catch (error) {
        showError('An error occurred during login. Please try again.');
    }
}

function showError(message) {
    const errorMessageElement = document.getElementById('error-message');
    if (errorMessageElement) {
        errorMessageElement.textContent = message;
        errorMessageElement.style.display = 'block';
    }
}

document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent default form submission

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    login(username, password);
});

if (!localStorage.getItem('returnUrl')) {
    localStorage.setItem('returnUrl', window.location.pathname);
}
