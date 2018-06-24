package com.simon.institution;

import org.apache.commons.lang.StringUtils;

import java.util.*;

class Institution {

    private static int count = 0;

    /**
     * 培训机构名称
     */
    private String name;

    /**
     * 学员信息列表
     */
    private Map<String, Trainee> stuMap = new HashMap<>();

    private Map<Integer, Course> openCourseMap = new HashMap<>();


    Institution(String s) {
        this.name = s;
    }

    public boolean register(String userId, String password) {

        if (StringUtils.isBlank(userId) || StringUtils.isBlank(password)) {
            return false;
        }

        if (stuMap.containsKey(userId)) {
            return false;
        }

        Trainee trainee = new Trainee(userId, password);
        stuMap.put(userId, trainee);

        return true;
    }

    public boolean login(String userId, String password) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(password)) {
            return false;
        }

        if (!stuMap.containsKey(userId)) {
            return false;
        } else {
            if (stuMap.get(userId).getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean openCourse(String name, Date startTime, Date endTime, int number) {
        if (StringUtils.isBlank(name) || startTime == null || endTime == null || number == 0) {
            return false;
        }

        Set<Map.Entry<Integer, Course>> courses = openCourseMap.entrySet();

        for (Map.Entry<Integer, Course> entry : courses) {
            if (entry.getValue().getName().equalsIgnoreCase(name) && (entry.getValue().isSatisfyByDate(startTime) || entry.getValue().isSatisfyByDate(endTime))) {
                return false;
            }
        }

        openCourseMap.put(++count, new Course(name, startTime, endTime, number));

        return true;
    }

    public boolean closeCourse(int courseID) {
        if (openCourseMap.containsKey(courseID)) {
            Course course = openCourseMap.get(courseID);
            if (course.getTrainingRoom() != null) {
                course.getTrainingRoom().setUsed(false);
            }

            openCourseMap.remove(courseID);
            return true;
        }
        return false;
    }

    public List<Course> getCourseByName(String name) {
        List<Course> resultList = new ArrayList<>();

        Set<Map.Entry<Integer, Course>> courses = openCourseMap.entrySet();

        for (Map.Entry<Integer, Course> entry : courses) {
            if (entry.getValue().isSatisfyByName(name)) {
                resultList.add(entry.getValue());
            }
        }

        return resultList;
    }

    public List<Course> getCourseByTime(Date startTime, Date endTime) {
        List<Course> resultList = new ArrayList<>();

        Set<Map.Entry<Integer, Course>> courses = openCourseMap.entrySet();

        for (Map.Entry<Integer, Course> entry : courses) {
            if (entry.getValue().isInRange(startTime, endTime)) {
                resultList.add(entry.getValue());
            }
        }

        return resultList;
    }

}
