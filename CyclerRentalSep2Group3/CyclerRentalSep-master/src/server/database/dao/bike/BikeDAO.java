package src.server.database.dao.bike;

import src.server.database.dao.DAO;
import src.shared.transferobjects.Bike;

public interface BikeDAO extends DAO<Bike> {
    boolean update(Bike bike, int id);
}
