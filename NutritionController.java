package app.controllers;

import app.models.NutritionPlan;
import app.services.NutritionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NutritionController {

    private final NutritionService nutritionService;
    public NutritionController(NutritionService nutritionService) { this.nutritionService = nutritionService; }

    // /nutrition – показва 3 карти (Cutting / Maintenance / Bulking)
    @GetMapping("/nutrition")
    public String nutritionList(Model model, HttpSession session){
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        model.addAttribute("plans", nutritionService.list());
        return "nutrition";
    }

    // /nutrition/{slug} – детайли на избрания план
    @GetMapping("/nutrition/{slug}")
    public String nutritionDetail(@PathVariable String slug, Model model, HttpSession session){
        NutritionPlan plan = nutritionService.findBySlug(slug);
        if (plan == null) return "redirect:/nutrition";
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        model.addAttribute("plan", plan);
        return "nutrition-detail";
    }
}