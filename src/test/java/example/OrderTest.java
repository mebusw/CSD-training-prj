package example;

import org.junit.Test;

import static org.junit.Assert.*;
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
        assertEquals("user1",ord.markUserinfo("user1","13360090101","深圳 科技园"));
        assertEquals(1,ord.getUserOrder());
        assertEquals("food 1 21",ord.prtUserOrder());

    }
    @Test
    public void testOrder2()
    {
        assertEquals(1,1);
        assertEquals(2,2);
    }

}