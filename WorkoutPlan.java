package app.models;


public class WorkoutPlan {
    private String name;
    private String description;
    private int duration;

    public void Workout(String name, String description, int duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    // Getters
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getDuration() { return duration; }
}