package src.client.models.bikeManager;


import src.shared.transferobjects.Bike;

import java.util.ArrayList;

public interface BikeModel {
    ArrayList<Bike> getAllBikes();
    Bike getBike(int id);

    boolean deleteBike(Bike bike);
    boolean insertBike(Bike bike);
    void updateBike(Bike bike, int id);
}
