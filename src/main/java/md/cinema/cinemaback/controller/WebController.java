package md.cinema.cinemaback.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    // Render registration page
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";  // This will return register.html from templates folder
    }

    // Render login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // This will return login.html from templates folder
    }
}
