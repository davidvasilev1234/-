package staj.services;

import staj.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private static UserService instance;
    private Map<String, User> userByEmail = new HashMap<>();

    private UserService() {}

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

}
