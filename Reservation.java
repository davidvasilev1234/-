package app.models;


public class Reservation {
    private Long id;
    private User user;
    private Trainer trainer;
    private String dateTime;

    public Reservation() {}
    public Reservation(Long id, User user, Trainer trainer, String dateTime) {
        this.id = id;
        this.user = user;
        this.trainer = trainer;
        this.dateTime = dateTime;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Trainer getTrainer() { return trainer; }
    public void setTrainer(Trainer trainer) { this.trainer = trainer; }
    public String getDateTime() { return dateTime; }
    public void setDateTime(String dateTime) { this.dateTime = dateTime; }
}