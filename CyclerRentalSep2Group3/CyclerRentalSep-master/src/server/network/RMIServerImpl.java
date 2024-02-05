package src.server.network;

import src.server.model.booking.BookingModelManager;
import src.server.model.bike.BikeModelManager;
import src.server.model.bike.BikeModelManagerImpl;
import src.server.model.booking.BookingModelManagerImpl;
import src.server.model.login.LoginModelManager;
import src.server.model.login.LoginModelManagerImpl;
import src.server.model.signup.SignupModelManager;
import src.server.model.signup.SignupModelManagerImpl;
import src.server.model.user.UserModelManager;
import src.server.model.user.UserModelManagerImpl;
import src.shared.network.ClientCallback;
import src.shared.network.RMIServer;
import src.shared.transferobjects.Bike;
import src.shared.transferobjects.Booking;
import src.shared.transferobjects.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RMIServerImpl implements RMIServer {
    private Map<ClientCallback, PropertyChangeListener> listeners = new HashMap<>();

    private final UserModelManager userModelManager;
    private final LoginModelManager loginModelManager;
    private final SignupModelManager signupModelManager;
    private final BikeModelManager bikeModelManager;
    private final BookingModelManager bookingModelManager;


    public RMIServerImpl() throws RemoteException {
        this.userModelManager = new UserModelManagerImpl();
        this.loginModelManager = new LoginModelManagerImpl();
        this.signupModelManager = new SignupModelManagerImpl();
        this.bikeModelManager = new BikeModelManagerImpl();
        this.bookingModelManager = new BookingModelManagerImpl();
        UnicastRemoteObject.exportObject(this, 0);
    }

    public void startServer(){
        Registry registry = null;
        try {
            registry = LocateRegistry.createRegistry(1099);
            registry.bind("CyclerRentalServer", this);
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registerClient(ClientCallback server) throws RemoteException {
        PropertyChangeListener listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                server.notifyAll();
            }
        };
        listeners.put(server, listener);
    }

    @Override
    public void unRegisterClient(ClientCallback server  ) throws RemoteException {
        PropertyChangeListener listener = listeners.get(server);
        if(listener != null) {
            //logModelManager.removePropertyChangeListener("NewLogEntry", listener);
        };
    }

    @Override
    public void registerCallback(ClientCallback ccb) throws RemoteException {
        System.out.println("Register Callback");
        /*chatManager.addPropertyChangeListener("Chat", evt -> {
            try {
                ccb.anything((Messages) evt.getNewValue());
            } catch (RemoteException e) {
                e.printStackTrace();
            }   */
    }

    @Override
    public boolean validateLogin(String email, String password) throws RemoteException {
        return loginModelManager.validateLogin(email, password);
    }

    @Override
    public boolean isNewUser(User user) throws RemoteException {
        return signupModelManager.isNewUser(user);
    }

    @Override
    public boolean signUpUser(User user) throws RemoteException {
        return signupModelManager.signUpUser(user);
    }

    @Override
    public User getUser(String email){
        return userModelManager.getUser(email);
    }

    @Override
    public ArrayList<Bike> getAllBikes() {
        return bikeModelManager.getAllBikes();
    }

    @Override
    public Bike getBike(int id) {
        return bikeModelManager.getBike(id);
    }

    @Override
    public boolean deleteBike(Bike bike) {
        return bikeModelManager.deleteBike(bike);
    }

    @Override
    public boolean insertBike(Bike bike) {
        return bikeModelManager.insertBike(bike);
    }

    @Override
    public void updateBike(Bike bike, int id) {
        bikeModelManager.updateBike(bike, id);
    }

    @Override
    public ArrayList<Booking> getAllBookings() {
        return bookingModelManager.getAllBookings();
    }

    @Override
    public Booking getBooking(int id) {
        return bookingModelManager.getBooking(id);
    }

    @Override
    public boolean deleteBooking(Booking booking) {
        return bookingModelManager.deleteBooking(booking);
    }

    @Override
    public boolean insertBooking(Booking booking) {
        return bookingModelManager.insertBooking(booking);
    }

    @Override
    public void updateBooking(Booking booking, int id) {
        bookingModelManager.updateBooking(booking, id);
    }
}
