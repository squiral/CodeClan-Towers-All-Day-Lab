import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BookingTest {

    Booking booking;
    Bedroom bedroom;

    @Before
    public void before(){
        bedroom = new Bedroom(101, 2, "Double");
        booking = new Booking(3, bedroom);
    }

    @Test
    public void canGetNumberOfNights(){
        assertEquals(3, booking.getNumberOfNights());
    }

    @Test
    public void canGetTotalBill(){
        assertEquals(300, booking.getTotalBill());
    }


}
