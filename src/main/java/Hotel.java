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
        Bedroom room = this.findVacantRoom(roomNumber);
        if (room != null) {
            room.addGuest(guest);
        }
    }


    public int countGuestsInBedroom(int roomNumber) {
        Bedroom room = this.findBedroom(roomNumber);
        return room.countGuests();
    }

    public ConferenceRoom findConferenceRoom(String name){

        for (ConferenceRoom conferenceRoom : this.conferenceRooms){
            if (conferenceRoom.getName() == name){
                return conferenceRoom;
            }
        }

        return null;

    }

    public void checkInGuestIntoConferenceRoom(String name, Guest guest) {
        ConferenceRoom conferenceRoom= this.findConferenceRoom(name);
        conferenceRoom.addGuest(guest);
    }

    public int countGuestsInConferenceRoom(String name) {
        ConferenceRoom conferenceRoom = this.findConferenceRoom(name);
        return conferenceRoom.countGuests();
    }

    public void checkOutGuestFromBedroom(int roomNumber) {
        Bedroom bedroom = this.findBedroom(roomNumber);
        bedroom.removeGuests();
    }

    public void checkOutGuestFromConferenceRoom(String name) {
        ConferenceRoom conferenceRoom = this.findConferenceRoom(name);
        conferenceRoom.removeGuests();
    }

    public Booking createBedroomBooking(int numberOfNights, int roomNumber) {
        Bedroom bedroom = this.findBedroom(roomNumber);
        Booking booking = new Booking(numberOfNights, bedroom);
        return booking;
    }

    public ArrayList<Bedroom> getVacantRooms() {
        ArrayList<Bedroom> vacantBedrooms = new ArrayList<Bedroom>();
        for (Bedroom bedroom : this.bedrooms) {
            if (bedroom.countGuests() == 0) {
                vacantBedrooms.add(bedroom);
            }
        }

        return vacantBedrooms;
    }

    public Bedroom findVacantRoom(int roomNumber){
        ArrayList<Bedroom> vacantBedrooms = this.getVacantRooms();
        for (Bedroom bedroom : vacantBedrooms){
            if (bedroom.getNumber() == roomNumber) {
                return bedroom;
            }
        }

        return null;

    }
}
