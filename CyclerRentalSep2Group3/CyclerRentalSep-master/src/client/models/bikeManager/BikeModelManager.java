package src.client.models.bikeManager;


import src.client.core.ClientFactory;
import src.client.network.Client;
import src.shared.transferobjects.Bike;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class BikeModelManager implements BikeModel {
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Client client;
    ClientFactory clientFactory;

    public BikeModelManager(Client client){
        clientFactory = new ClientFactory();
        this.client=client;
    }

    public ArrayList<Bike> getAllBikes(){
        return client.getAllBikes();
    }

    public Bike getBike(int id){
        return client.getBike(id);
    }

    public boolean deleteBike(Bike bike){
        return client.deleteBike(bike);
    }

    public boolean insertBike(Bike bike){
        return client.insertBike(bike);
    }

    public void updateBike(Bike subject, int id){
        client.updateBike(subject, id);
    }


}
