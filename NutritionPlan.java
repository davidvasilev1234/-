package app.models;

import java.util.List;

public class NutritionPlan {
    private final String slug;      // "cutting", "maintenance", "bulking"
    private final String title;     // заглавие
    private final String summary;   // кратко описание
    private final List<String> meals; // примерно меню/насоки

    public NutritionPlan(String slug, String title, String summary, List<String> meals) {
        this.slug = slug;
        this.title = title;
        this.summary = summary;
        this.meals = meals;
    }

    public String getSlug() { return slug; }
    public String getTitle() { return title; }
    public String getSummary() { return summary; }
    public List<String> getMeals() { return meals; }
}