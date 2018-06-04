package conference;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ConferenceTest {

    @Test
    public void testSearchConferenRoom() {
        ConferenceSearch search = new ConferenceSearch();
        List<Room>  rooms = search.search("杭州");
        Assert.assertEquals("001",rooms.get(0).getRoomid());
        rooms = search.search("上海");
        Assert.assertEquals("002",rooms.get(0).getRoomid());
        rooms = search.search("北京");
        Assert.assertEquals("003",rooms.get(0).getRoomid());
    }
    @Test
    public void testSubscribeRoom(){
        ConferenceSearch search = new ConferenceSearch();
        List<Room>  rooms = search.searchAndSortByPrice("杭州","free");
        System.out.println(rooms);
        Assert.assertTrue(rooms.size()>0);
        Assert.assertEquals("杭州",rooms.get(0).getAddr());
        Assert.assertEquals("free",rooms.get(0).getStatus());

    }
}
