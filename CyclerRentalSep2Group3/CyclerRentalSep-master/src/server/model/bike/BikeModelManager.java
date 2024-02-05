package src.server.model.bike;


import src.shared.transferobjects.Bike;

import java.util.ArrayList;

public interface BikeModelManager {
    ArrayList<Bike> getAllBikes();

    Bike getBike(int id);

    void updateBike(Bike bike, int id);

    boolean insertBike(Bike bike);

    boolean deleteBike(Bike bike);
}
