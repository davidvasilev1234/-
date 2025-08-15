package staj.services;

import staj.models.Trainer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TrainerService {
    // Singleton инстанция
    private static TrainerService instance;

    private Map<Integer, Trainer> trainers = new HashMap<>();

    // Приватен конструктор
    private TrainerService() {}

    // Метод за получаване на инстанцията
    public static TrainerService getInstance() {
        if (instance == null) {
            instance = new TrainerService();
        }
        return instance;
    }

    public void addTrainer(Trainer trainer) {
        trainers.put(trainer.getId(), trainer);
    }

    public void updateTrainer(Trainer trainer) {
        trainers.put(trainer.getId(), trainer);
    }

    public Trainer getTrainer(int id) {
        return trainers.get(id);
    }

    public Collection<Trainer> getAllTrainers() {
        return trainers.values();
    }
}