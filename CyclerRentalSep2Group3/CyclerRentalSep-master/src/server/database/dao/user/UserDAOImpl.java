package src.server.database.dao.user;

import src.server.database.DatabaseConnection;
import src.server.database.queue.DbUtils;
import src.shared.transferobjects.Booking;
import src.shared.transferobjects.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO{

    @Override
    public User get(int id) {
        Connection connectDB;
        PreparedStatement psGetUser = null;
        ResultSet resultSet = null;
        try {
            connectDB = DatabaseConnection.getInstance().getConnection();
            psGetUser = connectDB.prepareStatement("SELECT * FROM users WHERE userid = ? ");
            psGetUser.setInt(1, id);
            resultSet = psGetUser.executeQuery();
            while (resultSet.next()){
                User user = new User(resultSet.getInt("userid"), resultSet.getString("name"),resultSet.getString("email"), resultSet.getString("phonenumber"),resultSet.getString("password"), resultSet.getString("usertype"));
                return user;
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

    public User get(String email) {
        Connection connectDB;
        PreparedStatement psGetUser = null;
        ResultSet resultSet = null;
        try {
            connectDB = DatabaseConnection.getInstance().getConnection();
            psGetUser = connectDB.prepareStatement("SELECT * FROM users WHERE email = ? ");
            psGetUser.setString(1, email);
            resultSet = psGetUser.executeQuery();
            while (resultSet.next()){
                User user = new User(resultSet.getInt("userid"), resultSet.getString("name"),resultSet.getString("email"), resultSet.getString("phonenumber"),resultSet.getString("password"), resultSet.getString("usertype"));
                return user;
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
    public ArrayList<User> getAll() {
        ArrayList<User> userArrayList = new ArrayList<>();
        Connection connectDB;
        PreparedStatement psGetSubject = null;
        ResultSet resultSet = null;
        try {
            connectDB = DatabaseConnection.getInstance().getConnection();
            psGetSubject = connectDB.prepareStatement("SELECT * FROM users");
            resultSet = psGetSubject.executeQuery();
            while (resultSet.next()){
                User user = new User(resultSet.getInt("userid"), resultSet.getString("name"),resultSet.getString("email"), resultSet.getString("phonenumber"),resultSet.getString("password"), resultSet.getString("usertype"));
                userArrayList.add(user);
            }
            return userArrayList;
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
    public boolean save(User user) {
        return false;
    }

    @Override
    public boolean insert(User user) {
        Connection connectDB;
        PreparedStatement psInsertSubject = null;
        ResultSet resultSet = null;
        try {
            connectDB = DatabaseConnection.getInstance().getConnection();
            psInsertSubject = connectDB.prepareStatement("INSERT INTO users (name,email,phonenumber, password, usertype) VALUES (?,?,?,?,?)");
            psInsertSubject.setString(1,user.getName());
            psInsertSubject.setString(2,user.getEmail());
            psInsertSubject.setString(3,user.getPhoneNumber());
            psInsertSubject.setString(4,user.getPassword());
            psInsertSubject.setString(5,user.getUserType());
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
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        Connection connectDB;
        PreparedStatement psDeleteSubjects = null;
        ResultSet resultSet = null;
        try {
            connectDB = DatabaseConnection.getInstance().getConnection();
            psDeleteSubjects = connectDB.prepareStatement("DELETE FROM users WHERE userid = ?");
            psDeleteSubjects.setInt(1, user.getId());
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
}
