import java.lang.reflect.Array;
import java.util.ArrayList;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;

    public Hotel (ArrayList<Bedroom> bedrooms, ArrayList<ConferenceRoom> conferenceRooms){
        this.bedrooms = bedrooms;
        this.conferenceRooms = conferenceRooms;
    }

    public int countBedrooms() {
        return this.bedrooms.size();
    }

    public int countConferenceRooms() {
        return this.conferenceRooms.size();
    }

    public Bedroom findBedroom(int roomNumber){

        for (Bedroom bedroom : this.bedrooms){
            if (bedroom.getNumber() == roomNumber){
                return bedroom;
            }
        }

        return null;

    }

    public void checkInGuestInBedroom(int roomNumber, Guest guest) {
        Bedroom room = this.findBedroom(roomNumber);
        room.addGuest(guest);
    }


    public int guestListOfRoom(int roomNumber) {
        Bedroom room = this.findBedroom(roomNumber);
        return room.countGuests();
    }
}
