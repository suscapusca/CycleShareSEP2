package src.client.models.BookingModelManager;


import src.shared.transferobjects.Bike;
import src.shared.transferobjects.Booking;

import java.util.ArrayList;

public interface BookingModel {
    ArrayList<Booking> getAllBookings();
    Booking getBooking(int id);
    boolean deleteBooking(Booking booking);
    boolean insertBooking(Booking booking);
    void updateBooking(Booking booking, int id);
}
