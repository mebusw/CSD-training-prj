package example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by titian on 2016/5/31.
 */
public class OrderTest {
    @Test
    public void testList() throws Exception {
        Order ord = new Order();
        assertEquals("food 1 21",ord.listMenu() [0]);
    }

}