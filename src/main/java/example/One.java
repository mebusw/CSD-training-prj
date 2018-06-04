package example;

import java.io.*;

public class One {

    public static void main (String[] args)  throws IOException {
        if (args == null) {
            System.out.println("Args should be not null.");
            return;
        }

        String customer = "user";

        if (args[0].equals(customer)) {
            if (args.length == 1) {
                System.out.println("user need other args: search or reserve.");
                return;
            }

            System.out.println("Currently, there is not available meeting rooms.");
            return;
        }
    }
}