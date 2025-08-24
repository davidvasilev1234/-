package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage(@RequestParam(value="error", required=false) String error, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Невалидно потребителско име или парола!");
        }
        return "login"; // login.html
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username, @RequestParam String password) {
        // Примерни данни за вход
        if(("admin".equals(username) && "1234".equals(password)) ||
                ("user".equals(username) && "user123".equals(password))) {
            return "redirect:/dashboard"; // след логин -> dashboard
        } else {
            return "redirect:/login?error";
        }
    }
}