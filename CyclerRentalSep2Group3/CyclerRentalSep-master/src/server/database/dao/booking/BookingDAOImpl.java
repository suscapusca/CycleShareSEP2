package src.server.database.dao.booking;

import src.server.database.DatabaseConnection;
import src.server.database.queue.DbUtils;
import src.shared.transferobjects.Bike;
import src.shared.transferobjects.Booking;

import java.sql.*;
import java.util.ArrayList;

public class BookingDAOImpl implements BookingDAO{

    @Override
    public Booking get(int id) {
        Connection connectDB;
        PreparedStatement psGetUser = null;
        ResultSet resultSet = null;
        try {
            connectDB = DatabaseConnection.getInstance().getConnection();
            psGetUser = connectDB.prepareStatement("SELECT * FROM booking WHERE bookingid = ? ");
            psGetUser.setInt(1, id);
            resultSet = psGetUser.executeQuery();
            while (resultSet.next()){
                Booking booking = new Booking(resultSet.getInt("bookingid"),resultSet.getInt("customerid"), resultSet.getInt("bikeid"),resultSet.getDate("startingdate"), resultSet.getDate("enddate"),resultSet.getFloat("finalprice"));
                return booking;
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DbUtils.closeQuietly(psGetUser);
            DbUtils.closeQuietly(resultSet);
        }
        return null;
    }

    @Override
    public ArrayList<Booking> getAll() {
        ArrayList<Booking> bookingArrayList = new ArrayList<>();
        Connection connectDB;
        PreparedStatement psGetSubject = null;
        ResultSet resultSet = null;
        try {
            connectDB = DatabaseConnection.getInstance().getConnection();
            psGetSubject = connectDB.prepareStatement("SELECT * FROM booking");
            resultSet = psGetSubject.executeQuery();
            while (resultSet.next()){
                Booking booking = new Booking(resultSet.getInt("bookingid"), resultSet.getInt("customerid"), resultSet.getInt("bikeid"),resultSet.getDate("startingdate"), resultSet.getDate("enddate"),resultSet.getFloat("finalprice"));
                bookingArrayList.add(booking);
            }
            return bookingArrayList;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DbUtils.closeQuietly(psGetSubject);
            DbUtils.closeQuietly(resultSet);
        }
    }

    @Override
    public boolean save(Booking booking) {
        return false;
    }

    @Override
    public boolean insert(Booking booking) {
        System.out.println("insert");
        Connection connectDB;
        PreparedStatement psInsertSubject = null;
        ResultSet resultSet = null;
        try {
            connectDB = DatabaseConnection.getInstance().getConnection();
            psInsertSubject = connectDB.prepareStatement("INSERT INTO booking (customerid,bikeid,startingdate, enddate, finalprice) VALUES (?,?,?,?,?)");
            psInsertSubject.setInt(1,booking.getCustomerId());
            psInsertSubject.setInt(2,booking.getBikeId());
            psInsertSubject.setDate(3, new java.sql.Date(booking.getStartDate().getTime()));
            psInsertSubject.setDate(4, new java.sql.Date(booking.getEndDate().getTime()));
            psInsertSubject.setFloat(5,booking.getFinalPrice());
            resultSet = psInsertSubject.executeQuery();
            return true;
        }
        catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        finally {
            DbUtils.closeQuietly(psInsertSubject);
            DbUtils.closeQuietly(resultSet);
        }
    }

    @Override
    public boolean update(Booking booking) {
        return false;
    }

    @Override
    public boolean delete(Booking booking) {
        Connection connectDB;
        PreparedStatement psDeleteSubjects = null;
        ResultSet resultSet = null;
        try {
            connectDB = DatabaseConnection.getInstance().getConnection();
            psDeleteSubjects = connectDB.prepareStatement("DELETE FROM booking WHERE bookingid = ?");
            psDeleteSubjects.setInt(1, booking.getId());
            resultSet = psDeleteSubjects.executeQuery();
            return true;
        }
        catch (SQLException e) {
            return false;
        }
        finally {
            DbUtils.closeQuietly(psDeleteSubjects);
            DbUtils.closeQuietly(resultSet);
        }
    }

    @Override
    public boolean update(Booking booking, int id) {
        Connection connectDB;
        PreparedStatement psUpdateSubjects = null;
        ResultSet resultSet = null;
        try {
            connectDB = DatabaseConnection.getInstance().getConnection();
            psUpdateSubjects = connectDB.prepareStatement("UPDATE booking SET customerid=?, bikeid=?, startingdate=?, enddate=?, finalprice=? WHERE bookingid=?");
            psUpdateSubjects.setInt(1, booking.getCustomerId());
            psUpdateSubjects.setInt(2, booking.getBikeId());
            psUpdateSubjects.setDate(3, (Date) booking.getStartDate());
            psUpdateSubjects.setDate(4, (Date) booking.getEndDate());
            psUpdateSubjects.setFloat(5, booking.getFinalPrice());
            psUpdateSubjects.setInt(6, id);
            resultSet = psUpdateSubjects.executeQuery();
            return true;
        }
        catch (SQLException e) {
            return false;
        }
        finally {
            DbUtils.closeQuietly(psUpdateSubjects);
            DbUtils.closeQuietly(resultSet);
        }
    }
}
