package src.client.views.bookings;


import src.client.models.BookingModelManager.BookingModelManager;
import src.client.models.bikeManager.BikeModelManager;
import src.shared.transferobjects.Bike;
import src.shared.transferobjects.Booking;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookingViewModel {

    private ArrayList<Booking> bookings;
    private BookingModelManager bookingModelManager;

    public BookingViewModel(BookingModelManager bookingModelManager){
        this.bookingModelManager= bookingModelManager;
    }

    public void createBooking(Booking booking) throws SQLException {
        bookingModelManager.insertBooking(booking);
    }

    public void updateBooking(Booking booking, int id) {
        bookingModelManager.updateBooking(booking,id);
    }

    public ArrayList<Booking> getBookings() {
       return bookingModelManager.getAllBookings();
    }

    public void deleteBooking(Booking booking){
        bookingModelManager.deleteBooking(booking);
    }
}
