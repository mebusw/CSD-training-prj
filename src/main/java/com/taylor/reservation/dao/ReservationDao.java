package com.taylor.reservation.dao;

import com.taylor.reservation.domain.Reservation;

import java.io.Serializable;

public class ReservationDao implements Serializable {

    public Reservation getReservationById(Long reservationId) {
        return new Reservation();
    }

    public void update(Reservation reservation) {

    }
}
