package example;

import example.entity.User;
import example.service.UserService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {

  @Test
  public void test_add_one_user() throws Exception {

    UserService userService = new UserService();
    userService.add(new User());

    assertEquals(1, (userService.getUserList()).size());
  }

  @Test
  public void test_add_two_users() throws Exception {

    UserService userService = new UserService();
    userService.add(new User());
    userService.add(new User());

    assertEquals(2, (userService.getUserList()).size());
  }

  @Test
  public void test_add_one_user_result() throws Exception {

    UserService userService = new UserService();
    userService.add(new User("张三", "test@test.com", "13888888888"));

    assertEquals(1, (userService.getUserList()).size());
    User user = userService.getUserList().get(0);

    assertEquals("张三", user.getName());
    assertEquals("test@test.com", user.getEmail());
    assertEquals("13888888888", user.getPhone());
  }

  @Test
  public void test_user_confirm() throws Exception {
    User user = new User("张三", "test@test.com", "13888888888");
    user.confirm();

    assertTrue(user.isConfirmed());
  }

  @Test
  public void test_user_unconfirm() throws Exception {
    User user = new User("张三", "test@test.com", "13888888888");
    assertFalse(user.isConfirmed());
  }

}