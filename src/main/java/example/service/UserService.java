package example.service;

import example.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> userList = new ArrayList<>();

    public void add(User user) {
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }
}
