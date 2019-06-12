import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GuestTest {

    Guest guest;

    @Before
    public void before(){
        guest = new Guest("String");
    }

    @Test
    public void canGetName(){
        assertEquals("String", guest.getName());
    }

}
