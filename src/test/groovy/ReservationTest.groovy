import com.simon.hotel.HotelSite
import com.simon.institution.Course
import com.simon.institution.Institution
import spock.lang.Specification

class ReservationTest extends Specification {

    def institution
    def hotelSite

    def setup() {
        institution = new Institution("Uperform")
        hotelSite = new HotelSite("城市酒店")
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
        startTime = "2018-07-01"
        endTime = "2018-07-03"
        startTimeOther = "2018-07-02"
        startTimeOther2 = "2018-07-04"
        endTimeOther = "2018-07-05"

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
        startTime = "2018-07-01"
        endTime = "2018-07-02"
        startTimeOther = "2018-07-03"
        endTimeOther = "2018-07-09"

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
        startTime = "2018-07-02"
        endTime = "2018-07-03"
        startTimeOther = "2018-07-07"
        endTimeOther = "2018-07-09"
        institution.openCourse("CSD培训", startTime, endTime, 5)
        institution.openCourse("CSM培训", startTimeOther, endTimeOther, 5)

        hotelSite.openTrainingRoom("RoomA", "Y", 30)

        then:
        def courseList1 = institution.getCourseByName("ABC")
        courseList1.size() == 0

        def courseList2 = institution.getCourseByName("CSD")
        courseList2.size() == 1

        def courseList3 = institution.getCourseByName("培训")
        courseList3.size() == 2

        def courseList4 = institution.getCourseByTime(new Date().updated(year: 2018, date: 1, month: 6), new Date().updated(year: 2018, date: 4, month: 7))
        courseList4.size() == 2
        courseList4[0].asType(Course).getTrainingRoom() == null // 没有培训室信息

        def courseList5 = institution.getCourseByTime(new Date().updated(year: 2018, date: 1, month: 6), new Date().updated(year: 2018, date: 1, month: 8))
        courseList5.size() == 2

        hotelSite.reserveRoom("RoomA", institution, institution.getCourseByName("CSD培训").get(0))
        def trainingName = institution.getTrainingNameByCourseName("CSD培训")
        trainingName == "RoomA"

    }

    def "报名课程" () {
        when:
        institution.openCourse("还未开始", "2018-08-01", "2018-08-03", 2)
        institution.openCourse("已经开始", "2018-06-30", "2018-07-03", 5)
        institution.openCourse("已经结束", "2018-06-01", "2018-06-03", 5)
        then:
        def result = institution.signUp4Course(3, "测试1")
        result == true

        def result2 = institution.signUp4Course(4, "测试")
        result2 == false

        def result4 = institution.signUp4Course(5, "测试")
        result4 == false

        institution.signUp4Course(3, "测试2")
        def result5 = institution.signUp4Course(3, "测试3")
        result5 == false
    }

    def "开放培训室" () {
        when:
        hotelSite.openTrainingRoom("RoomA", "Y", 30)
        institution.openCourse("课程1", "2018-06-30", "2018-07-03", 45)

        hotelSite.openTrainingRoom("RoomB", "Y", 30)
        institution.openCourse("课程2", "2018-06-25", "2018-06-30", 45)

        then:
        def openedSize = hotelSite.getOpenedSize()
        openedSize > 0;

        def result1 = hotelSite.openTrainingRoom("RoomA", "Y", 30)
        result1 == false

        hotelSite.reserveRoom("RoomB", institution, institution.getCourseByName("课程2").get(0))
        def result2 = hotelSite.openTrainingRoom("RoomB", "Y", 30)
        result2 == true
    }

    def "查询可以预约的培训室"() {
        when:
        hotelSite.openTrainingRoom("RoomA", "Y", 30)
        hotelSite.openTrainingRoom("RoomB", "N", 40)
        hotelSite.openTrainingRoom("RoomC", "N", 50)
        institution.openCourse("课程1", "2018-06-30", "2018-07-03", 45)

        then:
        def openedSize = hotelSite.searchWithWife("Y")
        openedSize == 1

        def satifySize = hotelSite.searchWithCap(35)
        satifySize == 2

        hotelSite.reserveRoom("RoomC", institution, institution.getCourseByName("课程1").get(0))
        def openSize = hotelSite.getOpenedSize()
        openSize == 2
    }

    def "预约培训室" () {
        when:
        hotelSite.openTrainingRoom("RoomA", "Y", 30)
        hotelSite.openTrainingRoom("RoomB", "N", 40)
        institution.openCourse("课程1", "2018-06-30", "2018-07-03", 5)
        institution.openCourse("课程2", "2018-07-30", "2018-08-03", 5)

        then:
        def result = hotelSite.reserveRoom("RoomA", institution, institution.getCourseByName("课程1").get(0))
        result == true

        def result2 = hotelSite.reserveRoom("RoomA", institution, institution.getCourseByName("课程2").get(0))
        result2 == false
    }

    def "释放预约的培训室" () {
        when:
        hotelSite.openTrainingRoom("RoomA", "Y", 30)
        hotelSite.openTrainingRoom("RoomB", "Y", 30)
        hotelSite.openTrainingRoom("RoomC", "Y", 30)
        institution.openCourse("课程1", "2018-06-30", "2018-07-03", 25)
        institution.openCourse("课程2", "2018-06-1", "2018-06-03", 25)
        institution.openCourse("课程3", "2018-07-30", "2018-08-03", 25)

        then:
        def result1 = hotelSite.releaseTrainingRoom("RoomA")
        result1 == false

        hotelSite.reserveRoom("RoomA", institution, institution.getCourseByName("课程1").get(0))
        hotelSite.reserveRoom("RoomB", institution, institution.getCourseByName("课程2").get(0))
        hotelSite.reserveRoom("RoomC", institution, institution.getCourseByName("课程3").get(0))

        def result2 = hotelSite.releaseTrainingRoom("RoomA")
        result2 == false

        def result3 = hotelSite.releaseTrainingRoom("RoomB")
        result3 == true

        def openSize = hotelSite.getOpenedSize()
        openSize == 1

        def result4 = hotelSite.releaseTrainingRoom("RoomC")
        result4 == true

        def openSize2 = hotelSite.getOpenedSize()
        openSize2 == 2






    }

}