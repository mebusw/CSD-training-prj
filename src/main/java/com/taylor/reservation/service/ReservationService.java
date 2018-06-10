package com.taylor.reservation.service;

import com.taylor.reservation.dao.ReservationDao;
import com.taylor.reservation.domain.Reservation;
import com.taylor.reservation.domain.ReservationState;

public class ReservationService {

    private ReservationDao reservationDao;

    public Reservation getReservation(Long reservationId) {
        return reservationDao.getReservationById(reservationId);
    }

    public Reservation rejectReservation(Long reservationId, String rejectMark) {
        Reservation reservation = getReservation(reservationId);
        reservation.setReservationState(ReservationState.REJECTED);
        reservation.setHotelComments(rejectMark);
        reservationDao.update(reservation);
        return reservation;
    }

    public ReservationDao getReservationDao() {
        return reservationDao;
    }

    public void setReservationDao(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }
}
