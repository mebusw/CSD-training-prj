package example;

public class UserInfo {
    private  String username;
    private  String phone;
    private  String address;

    public UserInfo(String user1, String phone_str, String str_addr) {
        username = user1;
        phone = phone_str;
        address = str_addr;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
    public String toString(){return "User:"+username+"\n"
     +"Phone:"+phone+"\n"
      +  "Address:"+address;
    };
}
