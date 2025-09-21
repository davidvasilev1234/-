package app.controllers;

import app.models.User;
import app.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    private final UserService users;
    public AuthController(UserService users) { this.users = users; }

    @GetMapping("/login")
    public String loginPage(Model m, HttpSession s) {
        m.addAttribute("currentUser", s.getAttribute("currentUser"));
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpSession session,
                          Model model) {
        var u = users.findByUsername(username);
        if (u.isPresent() && u.get().getPassword().equals(password)) {
            session.setAttribute("currentUser", u.get().getUsername());
            return "redirect:/";
        }
        model.addAttribute("error", "Грешно потребителско име или парола");
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model m, HttpSession s) {
        m.addAttribute("currentUser", s.getAttribute("currentUser"));
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@RequestParam String username,
                             @RequestParam String password,
                             Model model) {
        if (users.exists(username)) {
            model.addAttribute("error", "Потребителското име е заето");
            return "register";
        }
        users.save(new User(username, password, "USER"));
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}