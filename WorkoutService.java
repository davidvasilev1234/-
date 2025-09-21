package app.services;

import app.models.WorkoutPlan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WorkoutService {

    private final List<WorkoutPlan> plans = List.of(
            new WorkoutPlan(
                    "full-body",
                    "Full Body Workout",
                    "Програма за цялото тяло — 3 пъти седмично.",
                    List.of(
                            "Ден A: Клек 4x8, Лег 4x8, Гребане с щанга 4x10, Планк 3x45сек",
                            "Ден B: Мъртва тяга 4x6, Военна преса 4x8, Набирания 4xAMRAP, Руска чаша 3x12",
                            "Ден C: Напади 3x10/крак, Дъмбел лег 3x10, Кабелно гребане 3x12, Корем: колело 3x15"
                    )
            ),
            new WorkoutPlan(
                    "strength",
                    "Strength Training",
                    "Фокус върху сила и мускулна маса.",
                    List.of(
                            "5x5 Клек, 5x5 Лег, 5x5 Набирания/Гребане",
                            "5x5 Мъртва тяга, 5x5 Военна преса, 3x8 Хип тръст",
                            "Аксесоари: Бицепс/Трицепс 3x12, Странични вдигания 3x15"
                    )
            ),
            new WorkoutPlan(
                    "cardio-fat-burn",
                    "Cardio & Fat Burn",
                    "Кардио тренировки за изгаряне на мазнини.",
                    List.of(
                            "HIIT 20 мин: 40 сек бързо / 20 сек бавно × 10 кръга",
                            "Стабилно кардио: 35–45 мин на 65–75% HRmax",
                            "Кросфит стил: 5 кръга – 400м бягане, 20 суинга, 15 бурпита"
                    )
            )
    );

    public List<WorkoutPlan> list() { return plans; }

    public WorkoutPlan findBySlug(String slug) {
        return plans.stream()
                .filter(p -> p.getSlug().equals(slug))
                .findFirst()
                .orElse(null);
    }
}