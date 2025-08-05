package staj.models;

public class Trainer {
    private int id;
    private String name;
    private String specialty;

    private Trainer(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.specialty = builder.specialty;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecialty() { return specialty; }


    public static class Builder {
        private int id;
        private String name;
        private String specialty;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSpecialty(String specialty) {
            this.specialty = specialty;
            return this;
        }

        public Trainer build() {
            return new Trainer(this);
        }
    }

}
