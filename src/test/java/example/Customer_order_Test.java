package example;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Customer_order_Test {
  @Test
  public void testFoo() throws Exception {
    Customer_order customer_order = new Customer_order();

//    assertEquals("getMenuList", customer_order.getMenuList());
  }

  @Test
  public void testSeconde() {

    assertEquals(1, 1);
  }

  @Test
  public void should_initial_Menu_List() {
    //given
   ArrayList menuList =new ArrayList();
    menuList.add("宫爆鸡丁");
    menuList.add("糖醋里脊");

    assertEquals(Arrays.asList("宫爆鸡丁","糖醋里脊"),Customer_order.initialMenuList( menuList));
    //When
    //Then
  }

  @Test
  public void should_get_Menu_List() {
    //given


    assertEquals(Arrays.asList("宫爆鸡丁","糖醋里脊"),Customer_order.getMenuList());

    //When
    //Then
  }


  @Test
  public void should_input_Name_Phone_And_Address() {
    //given

    //When
    //Then
  }

  @Test
  public void should_Create_Order() {
    //given
    //When
    //Then
  }
}