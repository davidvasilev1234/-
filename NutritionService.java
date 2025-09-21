package app.services;

import app.models.NutritionPlan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutritionService {

    private final List<NutritionPlan> plans = List.of(
            new NutritionPlan(
                    "cutting",
                    "Сваляне (Cutting)",
                    "Калориен дефицит, висок протеин, много зеленчуци.",
                    List.of(
                            "Закуска: Омлет 3 яйца + домати + пълнозърнест тост",
                            "Междинно: Гръцко кисело мляко + шепа ядки",
                            "Обяд: Пилешко филе + ориз басмати + салата",
                            "Междинно: Протеинов шейк",
                            "Вечеря: Сьомга/бяла риба + броколи + киноа"
                    )
            ),
            new NutritionPlan(
                    "maintenance",
                    "Поддържане (Maintenance)",
                    "Баланс протеин/въглехидрати/мазнини около TDEE.",
                    List.of(
                            "Закуска: Овес с мляко, банан и мед",
                            "Междинно: Плод по избор",
                            "Обяд: Пуешко месо + картофи + салата",
                            "Междинно: Кисело мляко + мед",
                            "Вечеря: Телешко/тофу + зеленчуци на тиган + булгур"
                    )
            ),
            new NutritionPlan(
                    "bulking",
                    "Качване (Bulking)",
                    "Лек калориен излишък, качествени въглехидрати и протеини.",
                    List.of(
                            "Закуска: Яйца + овесени палачинки + плод",
                            "Междинно: Сандвич с фъстъчено масло",
                            "Обяд: Паста/ориз + пилешко/телешко + зеленчуци",
                            "Междинно: Протеинов шейк + оризовки",
                            "Вечеря: Пица на тънка кора/картофи + извара/риба"
                    )
            )
    );

    public List<NutritionPlan> list() { return plans; }

    public NutritionPlan findBySlug(String slug) {
        return plans.stream().filter(p -> p.getSlug().equals(slug)).findFirst().orElse(null);
    }
}