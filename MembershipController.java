package app.controllers;

import app.services.MembershipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MembershipController {
    private final MembershipService membershipService;
    public MembershipController(MembershipService membershipService) { this.membershipService = membershipService; }

    @GetMapping("/memberships")
    public String memberships(Model model) {
        model.addAttribute("memberships", membershipService.list());
        return "memberships";
    }
}