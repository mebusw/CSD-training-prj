package example;

/**
 * Created by titian on 2016/5/31.
 */
public class Order {
    public static void main(String[] args)
    {
        Order ord = new Order();
        System.out.print(ord.list());
    }
    public String[] list()
    {
        String [] menu= {"food 1 23"};
        return menu;
    }
}
