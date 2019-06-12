import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BedroomTest {

    Bedroom bedroom;

    @Before
    public void before(){
        bedroom = new Bedroom(101, 2, "Double");
    }

    @Test
    public void hasNumber(){
        assertEquals(101, bedroom.getNumber());
    }




}
