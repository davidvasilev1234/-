package staj.services;

import staj.models.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {

    private static ReservationService instance;

    private List<Reservation> reservations = new ArrayList<>();

    private ReservationService() {}
    public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;
    }

    public void makeReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public boolean cancelReservation(int reservationId) {
        return reservations.removeIf(r -> r.getId() == reservationId);
    }
    public List<Reservation> getReservationsByUser(int userId) {
        List<Reservation> result = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getUserId() == userId) {
                result.add(r);
            }
        }
        return result;
    }

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

