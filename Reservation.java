package staj.models;

import java.time.LocalDateTime;

public class Reservation {
    private int id;
    private int userId;
    private int trainerId;
    private LocalDateTime time;

    // Приватен конструктор за Builder
    private Reservation(Builder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.trainerId = builder.trainerId;
        this.time = builder.time;
    }

    // Getters
    public int getId() { return id; }
    public int getUserId() { return userId; }
    public int getTrainerId() { return trainerId; }
    public LocalDateTime getTime() { return time; }

    // Опционално: ако искаш да се връща само датата като текст (примерна имплементация)
    public String getDate() {
        return time != null ? time.toLocalDate().toString() : "Няма дата";
    }

    // Builder вътрешен клас
    public static class Builder {
        private int id;
        private int userId;
        private int trainerId;
        private LocalDateTime time;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder setTrainerId(int trainerId) {
            this.trainerId = trainerId;
            return this;
        }

        public Builder setTime(LocalDateTime time) {
            this.time = time;
            return this;
        }

        public Reservation build() {
            return new Reservation(this);
        }
    }
}