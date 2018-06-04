package com.taylor.reservation.service;

import com.taylor.reservation.domain.Reservation;

public class ReservationService {

    public Reservation getReservation(Long reservationId) {
        Reservation reservation = new Reservation();
        reservation.setReservationId(1l);
        return reservation;
    }

    public void rejectReservation(Long reservationId, String rejectMark) {

    }
}
