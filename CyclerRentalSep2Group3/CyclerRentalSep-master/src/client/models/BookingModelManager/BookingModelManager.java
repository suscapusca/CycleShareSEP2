package src.client.models.BookingModelManager;


import src.client.core.ClientFactory;
import src.client.network.Client;
import src.shared.transferobjects.Bike;
import src.shared.transferobjects.Booking;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class BookingModelManager implements BookingModel {
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Client client;
    ClientFactory clientFactory;

    public BookingModelManager(Client client){
        clientFactory = new ClientFactory();
        this.client=client;
    }

    public ArrayList<Booking> getAllBookings(){
        return client.getAllBookings();
    }

    public Booking getBooking(int id){
        return client.getBooking(id);
    }

    public boolean deleteBooking(Booking booking){
        return client.deleteBooking(booking);
    }

    public boolean insertBooking(Booking booking){
        return client.insertBooking(booking);
    }

    public void updateBooking(Booking booking, int id){
        client.updateBooking(booking, id);
    }


}
