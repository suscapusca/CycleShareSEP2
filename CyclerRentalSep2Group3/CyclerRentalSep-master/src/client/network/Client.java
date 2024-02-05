package src.client.network;

import src.shared.transferobjects.Bike;
import src.shared.transferobjects.Booking;
import src.shared.transferobjects.User;
import src.shared.util.Subject;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface Client extends Subject {
    void startClient();
    void unRegisterClient();

    User getUser(String email);
    boolean validateLogin(String email, String password);
    boolean isNewUser(User user);
    boolean signUpUser(User user);

    ArrayList<Bike> getAllBikes();
    Bike getBike(int id);
    boolean deleteBike(Bike bike);
    boolean insertBike(Bike bike);
    void updateBike(Bike subject, int id);

    ArrayList<Booking> getAllBookings();
    Booking getBooking(int id);
    boolean deleteBooking(Booking booking);
    boolean insertBooking(Booking booking);
    void updateBooking(Booking booking, int id);
}
