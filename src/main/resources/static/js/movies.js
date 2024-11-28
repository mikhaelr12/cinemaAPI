async function fetchMovies() {
    try {
        const response = await fetch('http://localhost:8080/movies', {
            method: 'GET',
            headers: {
            }
        });

        if (response.ok) {
            const movies = await response.json();
            displayMovies(movies);
        } else {
            console.error("Failed to load movies:", response.status);
        }
    } catch (error) {
        console.error("Error fetching movies:", error);
    }
}

function displayMovies(movies) {
    const container = document.getElementById("movies-container");
    container.innerHTML = "";

    movies.forEach(movie => {
        const movieElement = document.createElement("div");
        movieElement.classList.add("movie");

        const movieImage = document.createElement("img");
        movieImage.src = movie.image;
        movieImage.alt = movie.title;
        movieElement.appendChild(movieImage);

        const movieTitle = document.createElement("h2");
        movieTitle.textContent = movie.title;
        movieElement.appendChild(movieTitle);

        const movieDescription = document.createElement("p");
        movieDescription.textContent = movie.description;
        movieElement.appendChild(movieDescription);

        const movieDuration = document.createElement("p");
        movieDuration.textContent = movie.duration;
        movieElement.appendChild(movieDuration);

        const movieGenre = document.createElement("p");
        movieGenre.textContent = "Genre: " + movie.genreName;
        movieElement.appendChild(movieGenre);

        container.appendChild(movieElement);
    });
}

document.addEventListener('DOMContentLoaded', fetchMovies);
