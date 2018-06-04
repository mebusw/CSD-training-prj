package com.teamB;


import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class RoomSearcherTest {
    @Test
    public void testSearch() throws Exception {
        RoomSearcher searcher = new RoomSearcher();
        List<Room> rooms = searcher.search("meeting", 20);

        assertTrue(rooms.size() > 0);
    }

    @Test
    public void testBooking() throws Exception {
        RoomSearcher searcher = new RoomSearcher();
        List<Room> rooms = searcher.search("meeting", 20);
        assertTrue(rooms.size() > 0);
        Room room = rooms.get(0);

        Booker booker = new Booker();
        boolean bookResult = booker.requestRoom(room);

        assertTrue(bookResult);
    }

}