package com.simon.institution;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Institution {

    /**
     * 培训机构名称
     */
    private String name;

    /**
     * 学员信息列表
     */
    private Map<String, Trainee> stuMap = new HashMap<>();

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
}
