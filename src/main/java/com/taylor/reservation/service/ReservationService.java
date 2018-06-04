package com.taylor.reservation.service;

import com.taylor.reservation.domain.Reservation;
import com.taylor.reservation.domain.ReservationState;

public class ReservationService {

    public Reservation getReservation(Long reservationId) {
        Reservation reservation = new Reservation();
        reservation.setReservationId(1l);

        if(reservationId == 1L) {
            reservation.setReservationState(ReservationState.RESERVED);
        }
        return reservation;
    }

    public void rejectReservation(Long reservationId, String rejectMark) {

    }
}
