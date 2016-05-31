package example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Customer_order {
    private static ArrayList menuList;
    //    String message = "getMenuList";
//    private List menuList;
    private int order_count;
    //    private ArrayList menuList;


    public void createOrder(int i){
        order_count+=i;
    }



    public static List getMenuList() {
        menuList =new ArrayList();
        menuList.add("宫爆鸡丁");
        menuList.add("糖醋里脊");

        return menuList;
    }

//    public static

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

    public static List initialMenuList(ArrayList menu) {
        menuList=menu;
        return menuList;
    }
}