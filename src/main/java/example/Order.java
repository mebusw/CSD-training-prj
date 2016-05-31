package example;

/**
 * Created by titian on 2016/5/31.
 */
public class Order {
    private int userOrder =0 ;
    private String[] menu = new String[]{"food 1 21","food 2 22","food 3 23"};;

    public static void main(String[] args)
    {
        Order ord = new Order();
        System.out.print(ord.listMenu());
    }
    public String[] listMenu()
    {
        return menu;
    }

    public boolean select(int i) {
        userOrder = i;
        return true;
    }

    public int getUserOrder() {

        return userOrder;
    }

    public String prtUserOrder() {
        return menu[userOrder-1];
    }

    public String markUserinfo(String user1, String s, String s1) {
        return "user1";
    }
}
