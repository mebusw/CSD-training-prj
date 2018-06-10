package com.taylor.reservation

import com.taylor.reservation.dao.ReservationDao
import com.taylor.reservation.domain.*
import com.taylor.reservation.service.CustomerService
import com.taylor.reservation.service.HotelService
import com.taylor.reservation.service.ReservationService
import spock.lang.Specification

import java.util.function.Consumer

class ClientTest extends Specification {

    ReservationDao reservationDao = Mock()


    def "用for循环里面进行断言"() {
        given: ""
        List<String> ones = Arrays.asList("one1", "one", "one")

        when: "用for循环形式断言"
        then:
        for (String item : ones) {
            "one" == item   //应该失败然而通过了
        }
        for (String item : ones) {
            "one" != item   //应该失败然而通过了
        }

        when: "直接取出其中一条断言"
        then:
        ones.get(0) == "one1" //正确通过了

        when: "用for i 遍历 用get(i)方式取元素断言"
        then:
        for (int i = 0; i < ones.size(); i++) {
            def one = ones.get(i)
            "one" == one    //应该失败然而通过了
        }
    }

    def "用java 8 的Iterable forEach循环断言"() {
        given: ""
        List<String> ones = Arrays.asList("one1", "one", "one", "one")
        when: "用java 8 之前的for循环断言"
        then: "结果"
        when: "用java 8 的Iterable forEach循环断言"
        then: "结果无效，断言应该失败却通过了测试"
        ones.forEach(new Consumer<String>() {
            @Override
            void accept(String item) {
                "one" == item
            }
        })
    }

    def "搜索满足会议室条件的酒店"() {
        given:
        def service = new HotelService()
        def criteria = HotelCriteria.create().roomHasWifi(true).roomOutletNumGt(10).roomSeatsNumGt(10).roomPriceGt(1000).roomPriceLt(2000)
        criteria.roomStartTime("2018-06-02").roomEndTime("2018-06-02")

        when:
        Collection<Hotel> hotels = service.search(criteria)
        List<Room> rooms = new ArrayList<>()
        hotels.forEach(new Consumer<Hotel>() {
            @Override
            void accept(Hotel hotel) {
                rooms.addAll(hotel.getRooms())
            }
        })
        then:
        hotels.size() <= 5
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i)
            room.hasWifi() == true
            room.getOutletNumber() > 10
            room.getSeatsNumer() > 10
            room.getPrice() > 1000
            room.getPrice() < 2000
        }

    }

    def "查询酒店会议室预约"() {
        given: "预约服务和预约申请"
        def reservationService = new ReservationService()
        reservationService.setReservationDao(reservationDao)
        def reservation = new Reservation()
        reservation.setReservationId(1l)
        reservationDao.getReservationById(1l) >> reservation
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
        given: "预约服务接口"
        ReservationService reservationService = new ReservationService()
        reservationService.setReservationDao(reservationDao)

        Reservation reservation = new Reservation()
        reservation.setReservationId(2l)
        reservation.setHotelComments("装修中")
        reservationDao.getReservationById(2l) >> reservation

        when: "拒绝预约"
        Reservation result = reservationService.rejectReservation(2l, "装修中")

        then:
        ReservationState.REJECTED == result.getReservationState()
        "装修中" == result.getHotelComments()
    }

}
