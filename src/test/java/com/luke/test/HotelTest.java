package com.luke.test;

import com.luke.hotel.ConferenceRoom;
import com.luke.hotel.Hotel;
import com.luke.trainingagency.Student;
import com.luke.trainingagency.TrainingAgency;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {
    private static final int CLASS_TYPE_NORMAL = 1;
    private static final int CLASS_TYPE_CSM = 2;
    private static final int CLASS_TYPE_CSD = 3;

    @Before
    public void setup(){

    }

    @Test
    public void testBookingHotel(){
        Hotel hotel = new Hotel();
        TrainingAgency uPerForm = new TrainingAgency();
        hotel.setConferenceRoom(new ConferenceRoom());

        assertEquals(Boolean.TRUE, hotel.booking(uPerForm));
    }

    @Test
    public void testTAInfoStudent(){
        Hotel hotel = new Hotel();
        TrainingAgency uPerForm = new TrainingAgency();
        hotel.setConferenceRoom(new ConferenceRoom());
        boolean result = hotel.booking(uPerForm);
//        Assert.assertEquals(Boolean.TRUE, hotel.booking(uPerForm));
        Student student = new Student("stu1", "139");
        uPerForm.notice(student);

        assertEquals("success", student.getNoticed());
    }

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
