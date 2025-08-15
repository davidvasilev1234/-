package staj.services;

import staj.models.WorkoutPlan;

import java.util.HashMap;
import java.util.Map;

public class WorkoutService {
    private static WorkoutService instance;

    private Map<Integer, WorkoutPlan> plans = new HashMap<>();

    private WorkoutService() {}

    public static WorkoutService getInstance() {
        if (instance == null) {
            instance = new WorkoutService();
        }
        return instance;
    }

    public void addWorkoutPlan(WorkoutPlan plan) {
        plans.put(plan.getUserId(), plan);
    }

    public void updateWorkoutPlan(WorkoutPlan plan) {
        plans.put(plan.getUserId(), plan);
    }

    public WorkoutPlan getWorkoutPlanByUserId(int userId) {
        return plans.get(userId);
    }
}