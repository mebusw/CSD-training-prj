package example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Customer_order {
    String message = "getMenuList";

    public String getMenuList() {
//        List menulist=ne

        return message;
    }

    public void uncoveredMethod() {
        System.out.println(getMenuList());
    }


    public static void main (String[] args)  throws IOException {
        if (args[0].equals("consume")) {
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(System.in));
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
            }
            catch (IOException e) {
                throw e;
            }
            finally {
                if (in != null) {
                    in.close();
                }
            }
        } else {
            for (String s: args) {
                System.out.println(s);
            }
        }

    }
}