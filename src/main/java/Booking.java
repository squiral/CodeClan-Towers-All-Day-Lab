public class Booking {

    private int numberOfNights;
    private Bedroom bedroom;

    public Booking (int numberOfNights, Bedroom bedroom){
        this.numberOfNights = numberOfNights;
        this.bedroom = bedroom;
    }

    public int getNumberOfNights() {
        return this.numberOfNights;
    }

    public int getTotalBill() {
        int rate = this.bedroom.getRate();
        int totalBill = rate * this.numberOfNights;
        return totalBill;

    }
}
