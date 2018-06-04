package com.luke.trainingagency;

import com.luke.hotel.Hotel;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainingAgency {

    public static final int CLASS_TYPE_NORMAL = 1;
    public static final int CLASS_TYPE_CSM = 2;
    public static final int CLASS_TYPE_CSD = 3;

    private Map<String, Student> studentMap;

    public TrainingAgency() {
        studentMap = new HashMap<String,Student>();
    }

    public Boolean booking(Hotel hotel, int classTypeCsd) {
        if(hotel.emptyRoom==0){
            return false;
        }
        return true;
    }

    public void notice(Student student) {
        student.setNoticed("success");
    }

    public void register(Student student) {
        this.studentMap.put(student.getName(), student);
    }

    public int getRegisterdStuSize() {
        return this.studentMap.size();
    }

    public boolean signUp(String name, int classTypeCsd) {
        if (studentMap.containsKey(name)) {
            Student student = studentMap.get(name);
            student.setLesson(classTypeCsd);
            return true;
        } else {
            return false;
        }
    }
}
