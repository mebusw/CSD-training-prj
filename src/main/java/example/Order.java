package example;

/**
 * Created by titian on 2016/5/31.
 */
public class Order {
    public static void main(String[] args)
    {
        Order ord = new Order();
        System.out.print(ord.listMenu());
    }
    public String[] listMenu()
    {
        String [] menu= {"food 1 21","food 2 22","food 3 23"};
        return menu;
    }
}
