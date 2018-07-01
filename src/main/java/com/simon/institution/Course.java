package com.simon.institution;

import com.simon.hotel.TrainingRoom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Course {

    private String name;

    private Date startTime;

    private Date endTime;

    private int number;

    private TrainingRoom trainingRoom;

    private List<String> trainees = new ArrayList<>();

    public Course(String name, Date startTime, Date endTime, int number) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.number = number;
    }

    public boolean isSatisfyByName(String name) {
        if (this.name.contains(name)) {
            return true;
        }
        return false;
    }

    public boolean isInRange(Date startTime, Date endTime) {
        if (!startTime.after(this.startTime) && !endTime.before(this.endTime)) {
            return true;
        }
        return false;
    }

    public boolean isSatisfyByDate(Date time) {
        if (!this.startTime.after(time) && !this.endTime.before(time)) {
            return true;
        }
        return false;
    }

    public boolean isSatisfyByNum() {
        if (trainees.size() < this.number) {
            return true;
        }
        return false;
    }

    public boolean isStart() {
        Date now = new Date();
        if (now.after(this.startTime)) {
            return true;
        }
        return false;
    }

    public boolean isEnded() {
        Date now = new Date();
        if (now.after(this.endTime)) {
            return true;
        }
        return false;
    }

    public boolean addTrainee(String userId) {
        if (isSatisfyByNum()) {
            this.trainees.add(userId);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TrainingRoom getTrainingRoom() {
        return trainingRoom;
    }

    public void setTrainingRoom(TrainingRoom trainingRoom) {
        this.trainingRoom = trainingRoom;
    }
}
