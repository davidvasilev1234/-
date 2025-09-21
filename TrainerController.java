package app.controllers;

import app.services.TrainerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrainerController {
    private final TrainerService trainerService;
    public TrainerController(TrainerService trainerService) { this.trainerService = trainerService; }

    @GetMapping("/trainers")
    public String trainers(Model model) {
        model.addAttribute("trainers", trainerService.list());
        return "trainers";
    }
}