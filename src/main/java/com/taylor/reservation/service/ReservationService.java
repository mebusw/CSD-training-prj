package com.taylor.reservation.service;

import com.taylor.reservation.dao.ReservationDao;
import com.taylor.reservation.domain.Reservation;
import com.taylor.reservation.domain.ReservationState;

public class ReservationService {

    protected ReservationDao reservationDao;

    public Reservation getReservation(Long reservationId) {
        return reservationDao.getReservationById(reservationId);
    }

    public void rejectReservation(Long reservationId, String rejectMark) {
        Reservation reservation = getReservation(reservationId);
        reservation.setReservationState(ReservationState.REJECTED);
        reservation.setHotelComments(rejectMark);
        reservationDao.update(reservation);
    }

    public ReservationDao getReservationDao() {
        return reservationDao;
    }

    public void setReservationDao(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }
}
