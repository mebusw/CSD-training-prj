package com.simon.institution;

public class Trainee {

    /**
     * 培训学员ID
     */
    private String userId;

    /**
     * 培训学员密码
     */
    private String password;

    public Trainee(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
