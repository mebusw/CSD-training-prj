package example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class OrderTest {
    @Test
    public void testList() throws Exception {
        Order ord = new Order();
        assertEquals("food 1 21",ord.listMenu() [0]);
        assertEquals("food 2 22",ord.listMenu() [1]);

    }
    @Test
    public void testOrder()
    {
        Order ord = new Order();
        assertEquals(true,ord.select(1));
        assertEquals("user1",ord.markUserinfo(new UserInfo("user1", "13360090101", "深圳 科技园")));
        assertEquals(1,ord.getUserOrder());
        assertEquals("food 1 21",ord.prtUserOrder());
        assertEquals("User:user1\n" +
                "Phone:13360090101\n" +
                "Address:深圳 科技园",ord.prtUserInfo());
    }
    @Test
    public void testOrder2()
    {
        Order ord = new Order();
        assertEquals(true,ord.select(2));
        assertEquals("user2",ord.markUserinfo(new UserInfo("user2", "13360090102", "深圳 科技园")));
        assertEquals(2,ord.getUserOrder());
        assertEquals("food 2 22",ord.prtUserOrder());
        assertEquals("User:user2\n" +
                "Phone:13360090102\n" +
                "Address:深圳 科技园",ord.prtUserInfo());
    }

}