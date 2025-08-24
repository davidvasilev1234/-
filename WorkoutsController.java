package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkoutsController {

    @GetMapping("/workouts")
    public String showWorkouts(Model model) {
        model.addAttribute("title", "Тренировъчна програма");
        model.addAttribute("monday", "Гърди и трицепс");
        model.addAttribute("tuesday", "Гръб и бицепс");
        model.addAttribute("wednesday", "Крака");
        model.addAttribute("thursday", "Рамо и корем");
        model.addAttribute("friday", "Смесена тренировка");
        return "workouts"; // workouts.html
    }
}