import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom;

    @Before
    public void before(){
        conferenceRoom = new ConferenceRoom("The Baz Room", 20);
    }

    @Test
    public void startsEmpty(){
        assertEquals(0, conferenceRoom.countGuests());
    }

}
