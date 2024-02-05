package src.shared;

import src.shared.transferobjects.Bike;
import src.shared.transferobjects.Booking;

public final class BookingHolder {

    private Booking booking;
    private final static BookingHolder INSTANCE = new BookingHolder();

    private BookingHolder() {}

    public static BookingHolder getInstance() {
        return INSTANCE;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}