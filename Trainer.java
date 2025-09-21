package app.models;

public class Trainer {
    private final String name;
    private final String specialty;
    private final String bio;

    public Trainer(String name, String specialty, String bio) {
        this.name = name; this.specialty = specialty; this.bio = bio;
    }
    public String getName() { return name; }
    public String getSpecialty() { return specialty; }
    public String getBio() { return bio; }
}