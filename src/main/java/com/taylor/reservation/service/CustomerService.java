package com.taylor.reservation.service;

import com.taylor.reservation.domain.Reservation;
import com.taylor.reservation.domain.ReservationState;

public class CustomerService {

    public Reservation reserve(Reservation reservation) {
        reservation.setReservationState(ReservationState.RESERVED);
        reservation.setReservationId(1l);
        return reservation;
    }

}
