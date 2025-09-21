package app.services;

import app.models.Trainer;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrainerService {
    public List<Trainer> list() {
        return List.of(
                new Trainer("Иван", "Силови тренировки", "Сертифициран треньор с 8+ години опит."),
                new Trainer("Мария", "Функционални", "Функционални тренировки и мобилност."),
                new Trainer("Петър", "Кардио & Кондиция", "HIIT, издръжливост и кондиция.")
        );
    }
}