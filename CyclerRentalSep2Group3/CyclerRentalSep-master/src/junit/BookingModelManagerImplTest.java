package src.junit;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import src.server.database.dao.booking.BookingDAO;
import src.server.database.dao.booking.BookingDAOImpl;
import src.shared.transferobjects.Booking;

import static org.junit.jupiter.api.Assertions.*;

class BookingModelManagerImplTest {

    private Booking booking ;


    @Before
    public void setUp() {
        //FILL THIS BOOKING OUT DEPENDEIN OD DATABSE INFO
      booking = new Booking();
    }
    @Test
    void insertBooking() {
        BookingDAO subjectsDAO= new BookingDAOImpl();
        assertTrue(subjectsDAO.insert(booking)); ;
    }
}