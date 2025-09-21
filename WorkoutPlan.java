package app.models;

import java.util.List;

public class WorkoutPlan {
    private final String slug;     // напр. "full-body"
    private final String title;    // име в списъка
    private final String summary;  // кратко описание
    private final List<String> workouts; // упражнения/сесии за страницата

    public WorkoutPlan(String slug, String title, String summary, List<String> workouts) {
        this.slug = slug; this.title = title; this.summary = summary; this.workouts = workouts;
    }

    public String getSlug() { return slug; }
    public String getTitle() { return title; }
    public String getSummary() { return summary; }
    public List<String> getWorkouts() { return workouts; }
}