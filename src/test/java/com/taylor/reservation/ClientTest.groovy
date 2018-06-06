package com.taylor.reservation

import com.taylor.reservation.dao.ReservationDao
import com.taylor.reservation.domain.*
import com.taylor.reservation.service.CustomerService
import com.taylor.reservation.service.HotelService
import com.taylor.reservation.service.ReservationService
import org.mockito.Mockito
import spock.lang.Specification

import static org.mockito.Matchers.any
import static org.mockito.Matchers.anyLong
import static org.mockito.Mockito.atLeastOnce
import static org.mockito.Mockito.times
import static org.mockito.Mockito.verify
import static org.mockito.Mockito.when

class ClientTest extends Specification {

    def "搜索满足会议室条件的酒店"() {
        given:
        def service = new HotelService()
        def criteria = HotelCriteria.create().roomHasWifi(true).roomOutletNumGt(10).roomSeatsNumGt(10).roomPriceGt(1000).roomPriceLt(2000)
        criteria.roomStartTime("2018-06-02").roomEndTime("2018-06-02")

        when:
        Collection<Hotel> hotels = service.search(criteria)

        then:
        hotels.size() <= 5
        def hotel = hotels.iterator().next()
        List<Room> rooms = hotel.getRooms()
        def room = rooms.get(0)
        room.hasWifi() == true
        room.getOutletNumber() > 10
        room.getSeatsNumer() > 10
        room.getPrice() > 1000
        room.getPrice() < 2000
    }

    def "查询酒店会议室预约"() {
        given:
        def reservationService = new ReservationService()
        ReservationDao mock = Mockito.mock(ReservationDao.class)
        reservationService.setReservationDao(mock)
        def reservation = new Reservation()
        reservation.setReservationId(1l)
        when(mock.getReservationById(1l)).thenReturn(reservation)

        when:
        Reservation result = reservationService.getReservation(1l)

        then:
        result != null
        result.getReservationId() == 1l

    }

    def "预定酒店会议室"() {
        given:
        def customerService = new CustomerService()
        def customerId = 123456l
        def roomId = 222222l
        def startDate = new Date(1528033197795 - 3600 * 33 * 30)
        def endDate = new Date(1528033197795 - 3600 * 37 * 30)
        def reservation = new Reservation()
        reservation.setCustomerId(customerId)
        reservation.setRoomId(roomId)
        reservation.setMeetingStartTime(startDate)
        reservation.setMeetingEndTime(endDate)
        reservation.setReservationState(ReservationState.INITIALIZED)

        when:
        Reservation result = customerService.reserve(reservation)

        then:
        reservation != null
        null != result.getReservationId()
        ReservationState.RESERVED == result.getReservationState()
        customerId == result.getCustomerId()
    }

    def "会议室特殊原因拒绝预约"() {
        given:
        def reservationService = new ReservationService()
        def reservationId = 2l
        def rejectMark = '装修中'
        def reservation = new Reservation()
        reservation.setReservationId(reservationId)
        reservation.setHotelComments(rejectMark)
        ReservationDao mock = Mockito.mock(ReservationDao.class)
        reservationService.setReservationDao(mock)
        when(mock.getReservationById(reservationId)).thenReturn(reservation)

        when:
        reservationService.rejectReservation(reservationId, rejectMark)
        Reservation result = reservationService.getReservation(reservationId)

        then:
        ReservationState.REJECTED == result.getReservationState()
        rejectMark == result.getHotelComments()

//        verify(mock, atLeastOnce()).getReservationById(2)
        verify(mock).update(any(Reservation.class))
    }

}
