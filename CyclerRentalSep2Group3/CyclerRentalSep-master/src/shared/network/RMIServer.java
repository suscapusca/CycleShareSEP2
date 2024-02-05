package src.shared.network;


import src.shared.transferobjects.Bike;
import src.shared.transferobjects.Booking;
import src.shared.transferobjects.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.ArrayList;

public interface RMIServer extends Remote{
    void registerClient(ClientCallback client) throws RemoteException;
    void unRegisterClient(ClientCallback client) throws  RemoteException;
    void registerCallback(ClientCallback ccb) throws RemoteException;

    boolean validateLogin(String email, String password) throws RemoteException;
    boolean isNewUser(User user)throws RemoteException;
    boolean signUpUser(User user) throws RemoteException;
    User getUser(String email) throws RemoteException;

    ArrayList<Bike> getAllBikes() throws RemoteException;
    Bike getBike(int id) throws RemoteException;
    boolean deleteBike(Bike bike) throws RemoteException;
    boolean insertBike(Bike bike) throws RemoteException;
    void updateBike(Bike bike, int id) throws RemoteException;

    ArrayList<Booking> getAllBookings() throws RemoteException;
    Booking getBooking(int id) throws RemoteException;
    boolean deleteBooking(Booking booking) throws RemoteException;
    boolean insertBooking(Booking booking) throws RemoteException;
    void updateBooking(Booking booking, int id) throws RemoteException;
}
