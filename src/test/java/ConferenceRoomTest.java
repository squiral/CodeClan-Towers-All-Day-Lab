import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom;
    Guest guest1;

    @Before
    public void before(){
        conferenceRoom = new ConferenceRoom("The Baz Room", 20);
        guest1 = new Guest("Malky");
    }

    @Test
    public void startsEmpty(){
        assertEquals(0, conferenceRoom.countGuests());
    }

    @Test
    public void canAddGuest(){
        conferenceRoom.addGuest(guest1);
        assertEquals(1, conferenceRoom.countGuests());
    }

    @Test
    public void canRemoveGuest(){
        conferenceRoom.addGuest(guest1);
        conferenceRoom.removeGuests();
        assertEquals(0, conferenceRoom.countGuests());
    }



}
