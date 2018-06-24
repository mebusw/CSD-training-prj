package com.simon.test

import com.simon.institution.Course
import com.simon.institution.Institution
import spock.lang.Specification

class ReservationTest extends Specification {

    def institution

    def setup() {
        institution = new Institution("Uperform")
    }

    def "填写账号和密码能够注册"() {
        expect:
        institution.register(userId, password) == true

        where:
        userId | password
        "abc" | "123"
    }

    def "错误账号和密码注册验证"() {
        given:

        when:
        institution.register("test", "1111")

        then:
        institution.register("test", "2222") >> false
        institution.register("", "1111") >> false
        institution.register("abc", "") >> false
        institution.register("", "") >> false
    }

    def "登陆功能验证"(){
        given:

        when:
        institution.register("abc", "1111")

        then:
        institution.login("abcd", "dddd") >> false
        institution.login("abc", "dddd") >> false
        institution.login("abc", "1111") >> true
    }

    def "开放课程功能验证"(){
        given:
        def startTime
        def endTime
        def startTimeOther
        def startTimeOther2
        def endTimeOther

        when:
        startTime = new Date().updated(year: 2018, date: 1, month: 7)
        endTime = new Date().updated(year: 2018, date: 3, month: 7)
        startTimeOther = new Date().updated(year: 2018, date: 2, month: 7)
        startTimeOther2 = new Date().updated(year: 2018, date: 4, month: 7)
        endTimeOther = new Date().updated(year: 2018, date: 5, month: 7)

        then:
        institution.openCourse("", startTime, endTime, 5) >> false
        institution.openCourse("CSD培训", null, endTime, 5) >> false
        institution.openCourse("CSD培训", startTime, null, 5) >> false
        institution.openCourse("CSD培训", null, null, 5) >> false
        institution.openCourse("CSD培训", startTime, endTime, 0) >> false
        institution.openCourse("CSD培训", startTime, endTime, 5) >> true

        then:
        institution.openCourse("CSD培训", startTime, endTime, 5) >> true
        institution.openCourse("CSD培训", startTime, endTime, 5) >> false
        institution.openCourse("CSD培训", startTimeOther, endTimeOther, 5) >> false
        institution.openCourse("CSD培训", startTimeOther2, endTimeOther, 5) >> true
        institution.openCourse("CSM培训", startTime, endTime, 5) >> true
    }

    def "关闭课程功能验证"(){
        given:
        def startTime
        def endTime
        def startTimeOther
        def endTimeOther

        when:
        startTime = new Date().updated(year: 2018, date: 1, month: 7)
        endTime = new Date().updated(year: 2018, date: 3, month: 7)
        startTimeOther = new Date().updated(year: 2018, date: 7, month: 7)
        endTimeOther = new Date().updated(year: 2018, date: 9, month: 7)

        then:
        institution.openCourse("CSD培训", startTime, endTime, 5) >> true
        institution.openCourse("CSM培训", startTimeOther, endTimeOther, 5) >> true
        institution.closeCourse(1) >> true
        institution.closeCourse(1) >> false
        institution.closeCourse(5) >> false
    }

    def "查询课程功能验证"(){
        given:
        def startTime
        def endTime
        def startTimeOther
        def endTimeOther

        when:
        startTime = new Date().updated(year: 2018, date: 1, month: 7)
        endTime = new Date().updated(year: 2018, date: 3, month: 7)
        startTimeOther = new Date().updated(year: 2018, date: 7, month: 7)
        endTimeOther = new Date().updated(year: 2018, date: 9, month: 7)
        institution.openCourse("CSD培训", startTime, endTime, 5)
        institution.openCourse("CSM培训", startTimeOther, endTimeOther, 5)

        then:
        def courseList1 = institution.getCourseByName("ABC")
        courseList1.size() == 0

        def courseList2 = institution.getCourseByName("CSD")
        courseList2.size() == 1

        def courseList3 = institution.getCourseByName("培训")
        courseList3.size() == 2

        def courseList4 = institution.getCourseByTime(new Date().updated(year: 2018, date: 1, month: 6), new Date().updated(year: 2018, date: 4, month: 7))
        courseList4.size() == 1
        courseList4[0].asType(Course).getTrainingRoom() == null // 没有培训室信息

        def courseList5 = institution.getCourseByTime(new Date().updated(year: 2018, date: 1, month: 6), new Date().updated(year: 2018, date: 1, month: 8))
        courseList5.size() == 2
    }

}