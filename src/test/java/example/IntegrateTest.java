package example;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class IntegrateTest {

    @Before
    public void setup(){
        One.meetingRoomManager.initialize();
    }

    @Test
    public void testMain_VendorAddARoom_Then_UserSearch() throws IOException {
        // change System for test
        final PrintStream original = System.out;
        final PrintStream mockPrintStream = mock(PrintStream.class);
        System.setOut(mockPrintStream);

        // arrange
        String[] vendorArgs = {"vendor", "vendor1", "add", "room1"};
        String[] userArgs = {"user", "search"};
        String expectedVendorOut = "vendor1 add room1";
        String expectedUserOut = "room1 from vendor1";

        // act
        One.main(vendorArgs);
        One.main(userArgs);

        // assert
        verify(mockPrintStream).println(expectedVendorOut);
        verify(mockPrintStream).println(expectedUserOut);

        // recover System
        System.setOut(original);
    }

    @Test
    public void testMain_VendorAddARoom_Then_UserSearch_Then_UserReserve() throws IOException {
        // change System for test
        final PrintStream original = System.out;
        final PrintStream mockPrintStream = mock(PrintStream.class);
        System.setOut(mockPrintStream);

        // arrange
        String[] vendorArgs = {"vendor", "vendor1", "add", "room1"};
        String[] userSearchArgs = {"user", "search"};
        String[] userReserveArgs = {"user", "reserve", "room1", "vendor1"};

        String expectedVendorOut = "vendor1 add room1";
        String expectedUserSearchOut = "room1 from vendor1";
        String expectedUserReserveOut = "Reserve room1 from vendor1 successful.";

        // act
        One.main(vendorArgs);
        One.main(userSearchArgs);
        One.main(userReserveArgs);

        // assert
        verify(mockPrintStream).println(expectedVendorOut);
        verify(mockPrintStream).println(expectedUserSearchOut);
        verify(mockPrintStream).println(expectedUserReserveOut);

        // recover System
        System.setOut(original);
    }
}