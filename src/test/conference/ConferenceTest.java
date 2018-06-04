package conference;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConferenceTest {

    @Test
    public void testSearchConferenRoom() {

        ConferenceSearch search = new ConferenceSearch();
        List<Room>  rooms = search.search();
        Assert.assertEquals("001",rooms.get(0).getRoomid());
        Assert.assertEquals("002",rooms.get(1).getRoomid());
        Assert.assertEquals("003",rooms.get(2).getRoomid());
    }
}
