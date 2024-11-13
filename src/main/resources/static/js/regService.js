document.getElementById("registerForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    const data = {
        username: username,
        password: password
    };

    fetch("/auth/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
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
            alert("Registration successful!");
            window.location.href = "/login";
        })
        .catch(error => {
            console.error("Error:", error);
            alert(error.message || "Registration failed");
        });
});