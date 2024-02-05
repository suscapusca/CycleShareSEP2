package src.server.model.booking;

import src.server.database.DatabaseConnection;
import src.server.database.dao.bike.BikeDAO;
import src.server.database.dao.bike.BikeDAOImpl;
import src.server.database.dao.booking.BookingDAO;
import src.server.database.dao.booking.BookingDAOImpl;
import src.shared.transferobjects.Bike;
import src.shared.transferobjects.Booking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingModelManagerImpl implements BookingModelManager {

    public ArrayList<Booking> getAllBookings() {
        BookingDAO subjectsDAO= new BookingDAOImpl();
        return subjectsDAO.getAll();
    }

    public Booking getBooking(int id){
        BookingDAO subjectsDAO= new BookingDAOImpl();
        return subjectsDAO.get(id);
    }

    public void updateBooking(Booking booking, int id){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        try{
            PreparedStatement query = connectDB.prepareStatement("UPDATE booking SET customerid = ?, bikeid = ?, startingdate = ?, enddate = ?, finalprice = ? WHERE bookingid = ?");
            query.setInt(1,booking.getCustomerId());
            query.setInt(2,booking.getBikeId());
            query.setDate(3, new java.sql.Date(booking.getStartDate().getTime()));
            query.setDate(4, new java.sql.Date(booking.getEndDate().getTime()));
            query.setFloat(5,booking.getFinalPrice());
            query.setInt(6,id);
            query.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public boolean insertBooking(Booking booking){
        BookingDAO subjectsDAO= new BookingDAOImpl();
        return subjectsDAO.insert(booking);
    }

    public boolean deleteBooking(Booking booking){
        BookingDAO subjectsDAO= new BookingDAOImpl();
        return subjectsDAO.delete(booking);
    }
}
