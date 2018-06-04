package com.taylor.reservation

import com.taylor.reservation.service.ReservationService
import com.taylor.reservation.domain.Room
import com.taylor.reservation.domain.ReservationState
import com.taylor.reservation.service.CustomerService
import com.taylor.reservation.domain.Hotel
import com.taylor.reservation.domain.HotelCriteria
import com.taylor.reservation.service.HotelService
import com.taylor.reservation.domain.Reservation
import spock.lang.Specification

class ClientTest extends Specification {

    def "搜索满足会议室条件的酒店"() {
        given:
            def service = new HotelService()
            def criteria = HotelCriteria.create().roomHasWifi(true).roomOutletNumGt(10).roomSeatsNumGt(10).roomPriceGt(1000).roomPriceLt(2000)
            criteria.roomStartTime("2018 06 02").roomEndTime("2018 06 02")
        when:
            Collection<Hotel> hotels = service.search(criteria)
        then:
            hotels.size() <= 5
        def hotel = hotels.iterator().next()
        List<Room> rooms = hotel.getRooms()
        def room = rooms.get(0)
            room.hasWifi()==true
            room.getOutletNumber() > 10
            room.getSeatsNumer() > 10
            room.getPrice() > 1000
            room.getPrice() < 2000
    }

    def "查询酒店会议室预约"() {
        given:
            def reservationService = new ReservationService();
        when:
            Reservation reservation = reservationService.getReservation(1l)
        then:
            reservation!=null
            reservation.getReservationId() == 1l

    }

    def "预定酒店会议室"() {
        given:
            def customerService = new CustomerService()
            def reservation = new Reservation()
            reservation.setCustomerId(123456l)
            reservation.setMeetingStartTime(new Date(1528033197795 - 3600*33*30))
            reservation.setMeetingEndTime(new Date( 1528033197795 - 3600*37*30))
            reservation.setRoomId(222222l)
            reservation.setReservationState(ReservationState.INITIALIZED)
            def reservationService = new ReservationService()
        when:
            Long reservationId = customerService.reserve(reservation)
            Reservation result = reservationService.getReservation(reservationId)
        then:
            reservation != null
            reservationId == result.getReservationId()
            ReservationState.RESERVED == result.getReservationState()
    }

    def "会议室特殊原因拒绝预约"() {
        given:
            def reservationService = new ReservationService()
            def reservationId=2l
            def rejectMark = '装修中'
        when:
            reservationService.rejectReservation(reservationId,rejectMark)
            Reservation result = reservationService.getReservation(reservationId)
        then:
            ReservationState.REJECTED == result.getReservationState()
    }

}
