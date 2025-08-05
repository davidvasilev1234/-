package staj.models;

import java.time.LocalDateTime;

public class Reservation {
    private int id;
    private int userId;
    private int trainerId;
    private LocalDateTime time;

    private Reservation(Builder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.trainerId = builder.trainerId;
        this.time = builder.time;
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public int getTrainerId() { return trainerId; }
    public LocalDateTime getTime() { return time; }

    public String getDate() {
        return time != null ? time.toLocalDate().toString() : "Няма дата";
    }

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
