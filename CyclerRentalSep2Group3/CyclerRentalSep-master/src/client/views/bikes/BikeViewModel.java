package src.client.views.bikes;


import src.client.models.bikeManager.BikeModelManager;
import src.shared.transferobjects.Bike;

import java.sql.SQLException;
import java.util.ArrayList;

public class BikeViewModel {

    private ArrayList<Bike> bikes;
    private BikeModelManager bikeModelManager;

    public BikeViewModel(BikeModelManager subjectModelManager){
        this.bikeModelManager= subjectModelManager;
    }

    public void createBike(Bike bike) throws SQLException {
        bikeModelManager.insertBike(bike);
    }

    public void updateBike(Bike bike, int id) {
        bikeModelManager.updateBike(bike,id);
    }

    public ArrayList<Bike> getBikes() {
       return bikeModelManager.getAllBikes();
    }

    public void deleteBike(Bike bike){
        bikeModelManager.deleteBike(bike);
    }
}
