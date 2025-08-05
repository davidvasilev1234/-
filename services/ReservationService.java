package staj.services;

import staj.models.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {

    // ✅ Сингълтън инстанция
    private static ReservationService instance;

    // Хранилище за резервации
    private List<Reservation> reservations = new ArrayList<>();

    // Приватен конструктор
    private ReservationService() {}

    // ✅ Метод за достъп до инстанцията
    public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }

    // Добавяне на резервация
    public void makeReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    // Отмяна на резервация
    public boolean cancelReservation(int reservationId) {
        return reservations.removeIf(r -> r.getId() == reservationId);
    }

    // Връщане на резервации по потребител
    public List<Reservation> getReservationsByUser(int userId) {
        List<Reservation> result = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getUserId() == userId) {
                result.add(r);
            }
        }
        return result;
    }

    // Връщане на резервации по треньор
    public List<Reservation> getReservationsByTrainer(int trainerId) {
        List<Reservation> result = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getTrainerId() == trainerId) {
                result.add(r);
            }
        }
        return result;
    }
}