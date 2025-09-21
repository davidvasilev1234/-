package app.controllers;

import app.models.WorkoutPlan;
import app.services.WorkoutService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WorkoutController {

    private final WorkoutService workoutService;
    public WorkoutController(WorkoutService workoutService) { this.workoutService = workoutService; }

    // /workouts – списък с 3-те карти
    @GetMapping("/workouts")
    public String workouts(Model model, HttpSession session){
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        model.addAttribute("workouts", workoutService.list());
        return "workouts";
    }

    // /workouts/{slug} – детайлна страница
    @GetMapping("/workouts/{slug}")
    public String workoutDetail(@PathVariable String slug, Model model, HttpSession session){
        WorkoutPlan plan = workoutService.findBySlug(slug);
        if (plan == null) return "redirect:/workouts"; // fallback
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        model.addAttribute("plan", plan);
        return "workout-detail";
    }
}