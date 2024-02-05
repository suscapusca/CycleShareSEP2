package src.server.model.booking;


import src.shared.transferobjects.Bike;
import src.shared.transferobjects.Booking;

import java.util.ArrayList;

public interface BookingModelManager {
    ArrayList<Booking> getAllBookings();
    Booking getBooking(int id);
    boolean deleteBooking(Booking booking);
    boolean insertBooking(Booking booking);
    void updateBooking(Booking booking, int id);
}
