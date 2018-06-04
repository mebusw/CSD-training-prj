package com.luke.test;

import com.luke.hotel.MeetingRoom;
import com.luke.hotel.Hotel;
import com.luke.trainingagency.Student;
import com.luke.trainingagency.TrainingAgency;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {
    private static final int CLASS_TYPE_NORMAL = 1;
    private static final int CLASS_TYPE_CSM = 2;
    private static final int CLASS_TYPE_CSD = 3;
//    private static final int CLASS_TYPE_NORMAL = 1;


//    @Test
//    public void test_book_when_has_meetingRoom(){
//        Hotel hotel = new Hotel();
//        TrainingAgency uPerForm = new TrainingAgency();
//        hotel.setConferenceRoom(new ConferenceRoom());
//
//        assertEquals(Boolean.TRUE, hotel.booking(uPerForm));
//    }

    @Test
    public void test_book_when_has_meetingRoom_only_with_no_wifi(){
        Hotel hotel = new Hotel();
        hotel.addMeetingRoom(new MeetingRoom(1, MeetingRoom.HAS_WIFI, 100));
        TrainingAgency uPerForm = new TrainingAgency();

        assertEquals(Boolean.FALSE, hotel.booking(uPerForm, MeetingRoom.NO_WIFI));
    }

    @Test
    public void test_book_when_has_meetingRoom_only_with_wifi(){
        Hotel hotel = new Hotel();
        TrainingAgency uPerForm = new TrainingAgency();
        hotel.addMeetingRoom(new MeetingRoom(1, MeetingRoom.HAS_WIFI, 100));

        assertEquals(Boolean.TRUE, hotel.booking(uPerForm, MeetingRoom.HAS_WIFI));
    }

    @Test
    public void test_book_when_has_meetingRoom_only_with_no_wifi_success(){
        Hotel hotel = new Hotel();
        hotel.addMeetingRoom(new MeetingRoom(1, MeetingRoom.NO_WIFI, 100));
        TrainingAgency uPerForm = new TrainingAgency();

        assertEquals(Boolean.TRUE, hotel.booking(uPerForm, MeetingRoom.NO_WIFI));
    }

    @Test
    public void test_book_when_has_meetingRoom_only_with_wifi_failed(){
        Hotel hotel = new Hotel();
        TrainingAgency uPerForm = new TrainingAgency();
        hotel.addMeetingRoom(new MeetingRoom(1, MeetingRoom.NO_WIFI, 100));

        assertEquals(Boolean.FALSE, hotel.booking(uPerForm, MeetingRoom.HAS_WIFI));
    }

    @Test
    public void test_book_when_has_meetingRoom_full(){
        Hotel hotel = new Hotel();
        TrainingAgency uPerForm = new TrainingAgency("agencyA");
        hotel.addMeetingRoom(new MeetingRoom(1, MeetingRoom.NO_WIFI, 100));
        hotel.addMeetingRoom(new MeetingRoom(2, MeetingRoom.NO_WIFI, 100));
        hotel.booking(uPerForm, MeetingRoom.NO_WIFI);
        hotel.booking(uPerForm, MeetingRoom.NO_WIFI);

        assertEquals(Boolean.FALSE, hotel.booking(uPerForm, MeetingRoom.NO_WIFI));
    }

//    @Test
//    public void test_book_when_not_has_meetingRoom(){
//        Hotel hotel = new Hotel();
//        TrainingAgency uPerForm = new TrainingAgency();
//        hotel.setConferenceRoom(new ConferenceRoom());
//
//        assertEquals(Boolean.TRUE, hotel.booking(uPerForm));
//    }
//
//    public void test_book_when_hotel_not_empty(){
//        Hotel hotel = new Hotel();
//        TrainingAgency uPerForm = new TrainingAgency();
//        hotel.setConferenceRoom(new ConferenceRoom());
//
//        assertEquals(Boolean.TRUE, hotel.booking(uPerForm));
//    }
//
//    @Test
//    public void testTAInfoStudent(){
//        Hotel hotel = new Hotel();
//        TrainingAgency uPerForm = new TrainingAgency();
//        hotel.setConferenceRoom(new ConferenceRoom());
//        boolean result = hotel.booking(uPerForm);
////        Assert.assertEquals(Boolean.TRUE, hotel.booking(uPerForm));
//        Student student = new Student("stu1", "139");
//        uPerForm.notice(student);
//
//        assertEquals("success", student.getNoticed());
//    }

    @Test
    public void testStudentRegister() {
        TrainingAgency uPerForm = new TrainingAgency();
        Student student = new Student("stu1", "139");
        uPerForm.register(student);
        assertEquals(1, uPerForm.getRegisterdStuSize());
    }

    @Test
    public void testLessonSignUp() {
        TrainingAgency uPerForm = new TrainingAgency();
        Student student = new Student("stu1", "139");
        uPerForm.signUp("stu1", TrainingAgency.CLASS_TYPE_CSD);
    }

}
