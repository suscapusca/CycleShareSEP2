package src.server.database.dao.booking;

import src.server.database.dao.DAO;
import src.shared.transferobjects.Bike;
import src.shared.transferobjects.Booking;

public interface BookingDAO extends DAO<Booking> {
    boolean update(Booking bike, int id);
}
