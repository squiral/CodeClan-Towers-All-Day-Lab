import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class HotelTest {

    Hotel hotel;
    Guest guest1;
    Guest guest2;
    Bedroom bedroom1;
    Bedroom bedroom2;
    ConferenceRoom conferenceRoom1;
    ConferenceRoom conferenceRoom2;
    ArrayList<Bedroom> bedrooms;
    ArrayList<ConferenceRoom> conferenceRooms;


    @Before
    public void before(){
        guest1 = new Guest("The Baz");
        guest2 = new Guest("Malky");

        bedroom1 = new Bedroom(101, 2, "Double");
        bedroom2 = new Bedroom(102, 3, "Triple");

        conferenceRoom1 = new ConferenceRoom("The Baz Room", 20);
        conferenceRoom2 = new ConferenceRoom("The Haz Room", 1);

        bedrooms = new ArrayList<Bedroom>();
        bedrooms.add(bedroom1);
        bedrooms.add(bedroom2);

        conferenceRooms = new ArrayList<ConferenceRoom>();
        conferenceRooms.add(conferenceRoom1);
        conferenceRooms.add(conferenceRoom2);

        hotel = new Hotel(bedrooms, conferenceRooms);
    }

    @Test
    public void hasBedrooms(){
        assertEquals(2, hotel.countBedrooms());
    }

    @Test
    public void hasConferenceRooms(){
        assertEquals(2, hotel.countConferenceRooms());
    }

    @Test
    public void canFindBedroom(){
        assertEquals(bedroom1, hotel.findBedroom(101));
    }

    @Test
    public void canGetGuestListOfRoom(){
        assertEquals(0, hotel.guestListOfRoom(101));
    }

    @Test
    public void canCheckGuestIntoRoom(){
        hotel.checkInGuestInBedroom(101, guest1);
        assertEquals(1, hotel.guestListOfRoom(101));
    }
}
