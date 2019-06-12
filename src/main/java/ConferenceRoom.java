import java.util.ArrayList;

public class ConferenceRoom {

    private String name;
    private int capacity;
    private ArrayList<Guest> guests;


    public ConferenceRoom (String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.guests = new ArrayList<Guest>();
    }


    public int countGuests() {
        return this.guests.size();
    }

    public String getName() {
        return this.name;
    }

    public void addGuest(Guest guest) {
        this.guests.add(guest);
    }

    public void removeGuests() {
        this.guests.clear();
    }
}
