import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BedroomTest {

    Bedroom bedroom;
    Guest guest;

    @Before
    public void before(){
        bedroom = new Bedroom(101, 2, "Double");
        guest = new Guest("Malky");
    }

    @Test
    public void hasNumber(){
        assertEquals(101, bedroom.getNumber());
    }

    @Test
    public void canAddGuest(){
        bedroom.addGuest(guest);
        assertEquals(1, bedroom.countGuests());
    }

    @Test
    public void canRemoveGuests(){
        bedroom.addGuest(guest);
        bedroom.removeGuests();
        assertEquals(0, bedroom.countGuests());
    }




}
