package app.services;

import app.models.User;
import app.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) { this.repo = repo; }

    public Optional<User> findByUsername(String username) { return repo.findByUsername(username); }
    public boolean exists(String username) { return repo.existsByUsername(username); }
    public User save(User u) { return repo.save(u); }
}