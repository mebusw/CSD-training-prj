package example;


public class Order {
    private int userOrder =0 ;
    private String[] menu = new String[]{"food 1 21","food 2 22","food 3 23"};;
    private  UserInfo user = new UserInfo("none","","");

    public static void main(String[] args)
    {
        Order ord = new Order();
        System.out.print(ord.listMenu().toString());
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

    public String markUserinfo(UserInfo userInfo) {
        user = userInfo;
        return user.getUsername();
    }

    public String prtUserInfo() {
        return user.toString();
    }
}
