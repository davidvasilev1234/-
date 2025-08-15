package staj.models;

public class WorkoutPlan {
    private int id;
    private int userId;
    private String description;

    // Приватен конструктор, използван само от Builder
    private WorkoutPlan(Builder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.description = builder.description;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getDescription() {
        return description;
    }

    // ✅ Builder вътрешен клас
    public static class Builder {
        private int id;
        private int userId;
        private String description;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public WorkoutPlan build() {
            return new WorkoutPlan(this);
        }
    }
}