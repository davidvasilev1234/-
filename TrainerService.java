package app.services;

import app.models.Trainer;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TrainerService {
    private List<Trainer> trainers = new ArrayList<>();

    public void addTrainer(Trainer trainer) { trainers.add(trainer); }
    public List<Trainer> getAllTrainers() { return trainers; }
}