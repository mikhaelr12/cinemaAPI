package md.cinema.cinemaback.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    // Render registration page
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    // Render login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
    @GetMapping("/index")
    public String showIndexPage() {
        return "index"; // Returns index.html (if it's in resources/templates)
    }
}
