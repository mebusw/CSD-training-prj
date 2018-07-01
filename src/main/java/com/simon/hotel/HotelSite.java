package com.simon.hotel;

import com.simon.institution.*;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HotelSite {

    private String name;

    private Map<String, TrainingRoom> trainingRooms = new HashMap<>();

    public HotelSite(String name) {
        this.name = name;
    }

    public boolean openTrainingRoom(String roomNo, String hasWifi, int capacity) {
        if (StringUtils.isBlank(roomNo) || StringUtils.isBlank(hasWifi) || capacity == 0) {
            return false;
        }

        if (trainingRooms.containsKey(roomNo)) {
            TrainingRoom trainingRoom = trainingRooms.get(roomNo);
            if (trainingRoom.isOpened()) {
                return false;
            } else {
                Course course = trainingRoom.getGoingCourse();
                // 如果可能已经结束可以重新开放
                if (!trainingRoom.isUsed() || course == null || (course != null && course.isEnded())) {
                    trainingRoom.setUsed(false);
                    trainingRoom.setOpened(true);
                    trainingRoom.setCustomerName(null);
                    trainingRoom.setGoingCourse(null);
                    return true;
                } else {
                    return false;
                }
            }
        }

        TrainingRoom trainingRoom = new TrainingRoom(roomNo, hasWifi, capacity);
        trainingRoom.setOpened(true);

        trainingRooms.put(roomNo, trainingRoom);
        return true;
    }

    public boolean releaseTrainingRoom(String roomNo) {
        if (StringUtils.isBlank(roomNo)) {
            return false;
        }

        if (trainingRooms.containsKey(roomNo)) {
            TrainingRoom trainingRoom = trainingRooms.get(roomNo);
            if (trainingRoom.isOpened() || !trainingRoom.isUsed()) {
                return false;
            } else {
                // 如果可能已经结束 或者还未开始 可以被强制释放
                Course course = trainingRoom.getGoingCourse();
                if (course != null && (course.isEnded() || !course.isStart())) {
                    trainingRoom.setUsed(false);
                    trainingRoom.setOpened(true);
                    trainingRoom.setCustomerName(null);
                    trainingRoom.setGoingCourse(null);
                    return true;
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    public int getOpenedSize() {
        int count = 0;
        for(Map.Entry<String, TrainingRoom> entry : trainingRooms.entrySet()) {
            if (entry.getValue().isOpened() && !entry.getValue().isUsed()) {
                count++;
            }
        }
        return count;
    }

    public int searchWithWife(String condition) {
        int count = 0;
        for(Map.Entry<String, TrainingRoom> entry : trainingRooms.entrySet()) {
            if (entry.getValue().isOpened() && entry.getValue().getHasWifi().equalsIgnoreCase(condition)) {
                count++;
            }
        }
        return count;
    }

    public int searchWithCap(int condition) {
        int count = 0;
        for(Map.Entry<String, TrainingRoom> entry : trainingRooms.entrySet()) {
            if (entry.getValue().isOpened() && entry.getValue().getCapacity() > condition) {
                count++;
            }
        }
        return count;
    }

    public boolean reserveRoom(String roomNo, Institution institution, Course course) {
        if (trainingRooms.containsKey(roomNo)) {
            TrainingRoom trainingRoom = trainingRooms.get(roomNo);
            if (trainingRoom.isOpened() && !trainingRoom.isUsed()) {
                trainingRoom.setUsed(true);
                trainingRoom.setOpened(false);
                trainingRoom.setCustomerName(institution.getName());
                trainingRoom.setGoingCourse(course);
                course.setTrainingRoom(trainingRoom);
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
