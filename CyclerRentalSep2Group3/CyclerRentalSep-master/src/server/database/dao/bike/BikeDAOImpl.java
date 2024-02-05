package src.server.database.dao.bike;

import src.server.database.DatabaseConnection;
import src.server.database.queue.DbUtils;
import src.shared.transferobjects.Bike;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BikeDAOImpl implements BikeDAO{

    @Override
    public Bike get(int id) {
        Connection connectDB;
        PreparedStatement psGetUser = null;
        ResultSet resultSet = null;
        try {
            connectDB = DatabaseConnection.getInstance().getConnection();
            psGetUser = connectDB.prepareStatement("SELECT * FROM bike WHERE bikeid = ? ");
            psGetUser.setInt(1, id);
            resultSet = psGetUser.executeQuery();
            while (resultSet.next()){
                Bike bike = new Bike(resultSet.getInt("bikeid"),resultSet.getString("brand"), resultSet.getString("category"),resultSet.getBoolean("availability"), resultSet.getInt("year"),resultSet.getFloat("price"));
                return bike;
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
    public ArrayList<Bike> getAll() {
        ArrayList<Bike> bikeArrayList = new ArrayList<>();
        Connection connectDB;
        PreparedStatement psGetSubject = null;
        ResultSet resultSet = null;
        try {
            connectDB = DatabaseConnection.getInstance().getConnection();
            psGetSubject = connectDB.prepareStatement("SELECT * FROM bike");
            resultSet = psGetSubject.executeQuery();
            while (resultSet.next()){
                Bike bike = new Bike(resultSet.getInt("bikeid"), resultSet.getString("brand"), resultSet.getString("category"),resultSet.getBoolean("availability"), resultSet.getInt("year"),resultSet.getFloat("price"));
                bikeArrayList.add(bike);
            }
            return bikeArrayList;
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
    public boolean save(Bike bike) {
        return false;
    }

    @Override
    public boolean insert(Bike bike) {
        Connection connectDB;
        PreparedStatement psInsertSubject = null;
        ResultSet resultSet = null;
        try {
            connectDB = DatabaseConnection.getInstance().getConnection();
            psInsertSubject = connectDB.prepareStatement("INSERT INTO bike (brand,category,availability, year, price) VALUES (?,?,?,?,?)");
            psInsertSubject.setString(1,bike.getBrand());
            psInsertSubject.setString(2,bike.getCategory());
            psInsertSubject.setBoolean(3,bike.isAvailability());
            psInsertSubject.setInt(4,bike.getYear());
            psInsertSubject.setFloat(5,bike.getPrice());
            resultSet = psInsertSubject.executeQuery();
            return true;
        }
        catch (SQLException e) {
            return false;
        }
        finally {
            DbUtils.closeQuietly(psInsertSubject);
            DbUtils.closeQuietly(resultSet);
        }
    }

    @Override
    public boolean update(Bike bike) {
        return false;
    }

    @Override
    public boolean delete(Bike bike) {
        Connection connectDB;
        PreparedStatement psDeleteSubjects = null;
        ResultSet resultSet = null;

        try {
            connectDB = DatabaseConnection.getInstance().getConnection();
            psDeleteSubjects = connectDB.prepareStatement("DELETE FROM bike WHERE bikeid = ?");
            psDeleteSubjects.setInt(1, bike.getId());
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
    public boolean update(Bike bike, int id) {
        Connection connectDB;
        PreparedStatement psUpdateSubjects = null;
        ResultSet resultSet = null;
        try {
            connectDB = DatabaseConnection.getInstance().getConnection();
            psUpdateSubjects = connectDB.prepareStatement("UPDATE bike SET brand=?, category=?, availability=?, year=?, price=? WHERE bikeid=?");
            psUpdateSubjects.setString(1, bike.getBrand());
            psUpdateSubjects.setString(2, bike.getCategory());
            psUpdateSubjects.setBoolean(3, bike.isAvailability());
            psUpdateSubjects.setInt(4, bike.getYear());
            psUpdateSubjects.setFloat(5, bike.getPrice());
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
