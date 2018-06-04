package example;

import com.google.gson.Gson;
import example.entity.User;
import example.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static UserService userService = new UserService();

    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.contains("addUser")) {
                    addUser(line);
                } else {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    private static void addUser(String line) {
        String[] info = line.split(",");
        userService.add(new User(info[1], info[2], info[3]));
        System.out.println((new Gson()).toJson(userService.getUserList()));
    }
}