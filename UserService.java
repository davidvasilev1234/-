package staj.services;

import staj.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private static UserService instance; // единствен обект
    private Map<String, User> userByEmail = new HashMap<>();
    private int nextId = 1;

    // private конструктор, за да не може да се създава отвън
    public UserService() {}

    // метод за взимане на единствената инстанция
    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public boolean register(User user) {
        if (userByEmail.containsKey(user.getEmail())) {
            return false;
        }
        userByEmail.put(user.getEmail(), user);
        nextId = Math.max(nextId, user.getId() + 1);
        return true;
    }

    public User login(String email, String passwordHash) {
        User user = userByEmail.get(email);
        if (user != null && user.getPasswordHash().equals(passwordHash)) {
            return user;
        }
        return null;
    }

    public User getUserProfile(String email) {
        return userByEmail.get(email);
    }

    public int getNextId() {
        return nextId++;
    }
}