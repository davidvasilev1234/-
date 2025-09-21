package app.services;

import app.models.Membership;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MembershipService {
    public List<Membership> list() {
        return List.of(
                new Membership("Basic", "50 лв/месец", "Достъп до всички тренировки.", false),
                new Membership("Standard", "250 лв/6 месеца", "Спести и тренирай редовно.", true),
                new Membership("Premium", "450 лв/година", "Неограничен достъп целогодишно.", false)
        );
    }
}