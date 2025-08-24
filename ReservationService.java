package app.services;


import app.models.Reservation;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private List<Reservation> reservations = new ArrayList<>();

    public void addReservation(Reservation reservation) { reservations.add(reservation); }
    public List<Reservation> getAllReservations() { return reservations; }
}