package src.client.network;

import src.shared.network.ClientCallback;
import src.shared.network.RMIServer;
import src.shared.transferobjects.Bike;
import src.shared.transferobjects.Booking;
import src.shared.transferobjects.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Timestamp;
import java.util.ArrayList;

public class RMIClient implements Client, ClientCallback, RMIServer {


    private RMIServer server;
    private PropertyChangeSupport support;

    public RMIClient() {
        support = new PropertyChangeSupport(this);
    }

    @Override
    public void startClient() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            server = (RMIServer) registry.lookup("CyclerRentalServer");
            server.registerClient(this);
            server.registerCallback(this);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void unRegisterClient() {
        try {
            server.unRegisterClient(this);
        } catch (RemoteException e) {

        }
    }

    @Override
    public User getUser(String email) {
        try {
            return server.getUser(email);
        } catch (RemoteException e) {
            throw new RuntimeException("Could not contact server");
        }
    }

    @Override
    public boolean validateLogin(String email, String password) {
        try {
            return server.validateLogin(email,password);
        } catch (RemoteException e) {
            throw new RuntimeException("Could not contact server");
        }
    }

    @Override
    public boolean isNewUser(User user) {
        try {
            return server.isNewUser(user);
        } catch (RemoteException e) {
            throw new RuntimeException("Could not contact server" + e);
        }
    }


    @Override
    public boolean signUpUser(User user) {
        try {
            return server.signUpUser(user);
        } catch (RemoteException e) {
            throw new RuntimeException("Could not contact server" + e);
        }
    }

    @Override
    public ArrayList<Bike> getAllBikes() {
        try {
            return server.getAllBikes();
        } catch (RemoteException e) {
            throw new RuntimeException("Could not contact server");
        }
    }

    @Override
    public Bike getBike(int id) {
        try {
            return server.getBike(id);
        } catch (RemoteException e) {
            throw new RuntimeException("Could not contact server");
        }
    }

    @Override
    public boolean deleteBike(Bike bike) {
        try {
            return server.deleteBike(bike);
        } catch (RemoteException e) {
            throw new RuntimeException("Could not contact server");
        }
    }

    @Override
    public boolean insertBike(Bike bike) {
        try {
            return server.insertBike(bike);
        } catch (RemoteException e) {
            throw new RuntimeException("Could not contact server");
        }
    }

    @Override
    public void updateBike(Bike bike, int id) {
        try {
            server.updateBike(bike, id);
        } catch (RemoteException e) {
            throw new RuntimeException("Could not contact server");
        }
    }

    @Override
    public ArrayList<Booking> getAllBookings() {
        try {
            return server.getAllBookings();
        } catch (RemoteException e) {
            throw new RuntimeException("Could not contact server");
        }
    }

    @Override
    public Booking getBooking(int id) {
        try {
            return server.getBooking(id);
        } catch (RemoteException e) {
            throw new RuntimeException("Could not contact server");
        }
    }

    @Override
    public boolean deleteBooking(Booking booking) {
        try {
            return server.deleteBooking(booking);
        } catch (RemoteException e) {
            throw new RuntimeException("Could not contact server");
        }
    }

    @Override
    public boolean insertBooking(Booking booking) {
        try {
            return server.insertBooking(booking);
        } catch (RemoteException e) {
            throw new RuntimeException("Could not contact server");
        }
    }

    @Override
    public void updateBooking(Booking booking, int id) {
        try {
            server.updateBooking(booking, id);
        } catch (RemoteException e) {
            throw new RuntimeException("Could not contact server");
        }
    }

    @Override
    public void registerClient(ClientCallback client) throws RemoteException {

    }

    @Override
    public void unRegisterClient(ClientCallback client) throws RemoteException {

    }

    @Override
    public void registerCallback(ClientCallback ccb) throws RemoteException {

    }

    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}
