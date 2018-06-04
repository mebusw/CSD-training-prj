package example;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class OneTest {

  @Before
  public void setup(){
    One.meetingRoomManager.initialize();
  }

  @Test
  public void testMainWithNullArgs() throws IOException {
    // change System for test
    final PrintStream original = System.out;
    final PrintStream mockPrintStream = mock(PrintStream.class);
    System.setOut(mockPrintStream);

    // arrange
    String[] args = null;
    String expectedOut = "Args should be not null.";


    // act
    One.main(args);

    // assert
    verify(mockPrintStream).println(expectedOut);

    // recover System
    System.setOut(original);
  }


  @Test
  public void testMainWithArgs_User_Without_EnoughArgsN() throws IOException {
    // change System for test
    final PrintStream original = System.out;
    final PrintStream mockPrintStream = mock(PrintStream.class);
    System.setOut(mockPrintStream);

    // arrange
    String[] args = {"user"};
    String expectedOut = "user need other args: search or reserve.";

    // act
    One.main(args);

    // assert
    verify(mockPrintStream).println(expectedOut);

    // recover System
    System.setOut(original);
  }


  @Test
  public void testMainWithArgs_User_With_Search_Without_Available_Rooms() throws IOException {
    // change System for test
    final PrintStream original = System.out;
    final PrintStream mockPrintStream = mock(PrintStream.class);
    System.setOut(mockPrintStream);

    // arrange
    String[] args = {"user", "search"};
    String expectedOut = "Currently, there is not available meeting rooms.";

    // act
    One.main(args);

    // assert
    verify(mockPrintStream).println(expectedOut);

    // recover System
    System.setOut(original);
  }


  @Test
  public void testMainWithArgs_Vendor_Without_EnoughArgsN() throws IOException {
    // change System for test
    final PrintStream original = System.out;
    final PrintStream mockPrintStream = mock(PrintStream.class);
    System.setOut(mockPrintStream);

    // arrange
    String[] args = {"vendor"};
    String expectedOut = "vendor need other args: add, remove or list.";

    // act
    One.main(args);

    // assert
    verify(mockPrintStream).println(expectedOut);

    // recover System
    System.setOut(original);
  }


  @Test
  public void testMainWithArgs_Vendor_With_AddRoom() throws IOException {
    // change System for test
    final PrintStream original = System.out;
    final PrintStream mockPrintStream = mock(PrintStream.class);
    System.setOut(mockPrintStream);

    // arrange
    String[] args = {"vendor", "vendor1", "add", "room1"};
    String expectedOut = "vendor1 add room1";

    // act
    One.main(args);

    // assert
    verify(mockPrintStream).println(expectedOut);

    // recover System
    System.setOut(original);
  }
}