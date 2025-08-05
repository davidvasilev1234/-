package staj.models;

import java.time.LocalDate;

public class Membership {
    private int id;
    private int userId;
    private String type; // monthly, yearly, gold и др.
    private LocalDate startDate;
    private LocalDate endDate;

    // Приватен конструктор за Builder-а
    private Membership(Builder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.type = builder.type;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    // Getters
    public int getId() { return id; }
    public int getUserId() { return userId; }
    public String getType() { return type; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }

    // Builder вътрешен клас
    public static class Builder {
        private int id;
        private int userId;
        private String type;
        private LocalDate startDate;
        private LocalDate endDate;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Membership build() {
            return new Membership(this);
        }
    }
}