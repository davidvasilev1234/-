package app.services;

import app.models.WorkoutPlan;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class WorkoutService {
    private List<WorkoutPlan> workouts = new ArrayList<>();

    public void addWorkout(WorkoutPlan workout) { workouts.add(workout); }
    public List<WorkoutPlan> getAllWorkouts() { return workouts; }
}