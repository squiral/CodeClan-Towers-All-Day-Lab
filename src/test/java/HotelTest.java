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
    Bedroom bedroom3;
    Bedroom bedroom4;
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
        bedroom3 = new Bedroom(103, 1, "Single");
        bedroom4 = new Bedroom(104, 2, "Twin");

        conferenceRoom1 = new ConferenceRoom("The Baz Room", 20);
        conferenceRoom2 = new ConferenceRoom("The Haz Room", 1);

        bedrooms = new ArrayList<Bedroom>();
        bedrooms.add(bedroom1);
        bedrooms.add(bedroom2);
        bedrooms.add(bedroom3);
        bedrooms.add(bedroom4);


        conferenceRooms = new ArrayList<ConferenceRoom>();
        conferenceRooms.add(conferenceRoom1);
        conferenceRooms.add(conferenceRoom2);

        hotel = new Hotel(bedrooms, conferenceRooms);
    }

    @Test
    public void hasBedrooms(){
        assertEquals(4, hotel.countBedrooms());
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
        assertEquals(0, hotel.countGuestsInBedroom(101));
    }

    @Test
    public void canCheckGuestIntoRoom(){
        hotel.checkInGuestInBedroom(101, guest1);
        assertEquals(1, hotel.countGuestsInBedroom(101));
    }

    @Test
    public void canFindConferenceRoom(){
        assertEquals(conferenceRoom1, hotel.findConferenceRoom("The Baz Room"));
    }

    @Test
    public void canCheckGuestIntoConferenceRoom(){
        hotel.checkInGuestIntoConferenceRoom("The Baz Room", guest1);
        assertEquals(1, hotel.countGuestsInConferenceRoom("The Baz Room"));
    }

    @Test
    public void canCheckOutGuestFromBedroom(){
        hotel.checkInGuestInBedroom(101, guest1);
        hotel.checkOutGuestFromBedroom(101);
        assertEquals(0, hotel.countGuestsInBedroom(101));
    }

    @Test
    public void canCheckOutGuestFromConferenceRoom(){
        hotel.checkInGuestIntoConferenceRoom("The Baz Room", guest1);
        hotel.checkOutGuestFromConferenceRoom("The Baz Room");
        assertEquals(0, hotel.countGuestsInConferenceRoom("The Baz Room"));
    }

    @Test
    public void canCreateBedroomBooking(){
        Booking booking = hotel.createBedroomBooking(3, 101);
        assertEquals(3, booking.getNumberOfNights());
    }

    @Test
    public void canGetVacantRooms(){
        hotel.checkInGuestInBedroom(101, guest1);
        ArrayList<Bedroom> vacantBedrooms = hotel.getVacantRooms();
        assertEquals(3, vacantBedrooms.size());


    }

    @Test
    public void wontCheckIntoNonVacantRoomWithPersonInItAlready(){
        hotel.checkInGuestInBedroom(101, guest1);
        hotel.checkInGuestInBedroom(101, guest2);

        assertEquals(1, hotel.countGuestsInBedroom(101));
    }



}
