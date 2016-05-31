package example;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by titian on 2016/5/31.
 */
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
        assertEquals(1,ord.getUserOrder());
    }

}