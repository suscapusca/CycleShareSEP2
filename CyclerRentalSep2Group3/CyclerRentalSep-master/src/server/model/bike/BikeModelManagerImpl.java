package src.server.model.bike;

import src.server.database.DatabaseConnection;
import src.server.database.dao.bike.BikeDAO;
import src.server.database.dao.bike.BikeDAOImpl;
import src.shared.transferobjects.Bike;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class BikeModelManagerImpl implements BikeModelManager {

    public ArrayList<Bike> getAllBikes() {
        BikeDAO subjectsDAO= new BikeDAOImpl();
        return subjectsDAO.getAll();
    }

    public Bike getBike(int id){
        BikeDAO subjectsDAO= new BikeDAOImpl();
        return subjectsDAO.get(id);
    }

    public void updateBike(Bike bike, int id){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        try{
            PreparedStatement query = connectDB.prepareStatement("UPDATE bike SET brand = ?, category = ?, availability = ?, year = ?, price = ? WHERE bikeid = ?");
            query.setString(1,bike.getBrand());
            query.setString(2,bike.getCategory());
            query.setBoolean(3,bike.isAvailability());
            query.setInt(4,bike.getYear());
            query.setFloat(5,bike.getPrice());
            query.setInt(6,id);
            query.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public boolean insertBike(Bike bike){
        BikeDAO subjectsDAO= new BikeDAOImpl();
        return subjectsDAO.insert(bike);
    }

    public boolean deleteBike(Bike bike){
        BikeDAO subjectsDAO= new BikeDAOImpl();
        return subjectsDAO.delete(bike);
    }
}
