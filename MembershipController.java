package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MembershipController {

    @GetMapping("/memberships")
    public String showMemberships(Model model) {
        model.addAttribute("plans", new String[][]{
                {"Стандартна", "Месечен достъп до фитнес", "30 лв."},
                {"Златна", "Месечен достъп + хранителни добавки", "50 лв."},
                {"Диамантена", "Пълен достъп + спа + хранителни добавки", "80 лв."}
        });
        return "memberships";
    }
}