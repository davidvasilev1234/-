package staj.models;

public class User {
    private int id;
    private String name;
    private String email;
    private String passwordHash;
    private String role;

    private User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.passwordHash = builder.passwordHash;
        this.role = builder.role;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
    public String getRole() { return role; }

    public static class Builder {
        private int id;
        private String name;
        private String email;
        private String passwordHash;
        private String role;

        public Builder setId(int id) { this.id = id; return this; }
        public Builder setName(String name) { this.name = name; return this; }
        public Builder setEmail(String email) { this.email = email; return this; }
        public Builder setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; return this; }
        public Builder setRole(String role) { this.role = role; return this; }

        public User build() {
            return new User(this);
        }
    }
}