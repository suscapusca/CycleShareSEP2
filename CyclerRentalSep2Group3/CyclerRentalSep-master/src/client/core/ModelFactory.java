package src.client.core;

import src.client.models.BookingModelManager.BookingModelManager;
import src.client.models.bikeManager.BikeModelManager;
import src.client.models.loginManager.LoginModelManager;
import src.client.models.signUpManager.SignUpModelManager;

public class ModelFactory {
    private final ClientFactory cf;
    private LoginModelManager loginModelManager;
    private SignUpModelManager signUpModelManager;
    private BikeModelManager bikeModelManager;
    private BookingModelManager bookingModelManager;

    public ModelFactory(ClientFactory cf) {
        this.cf = cf;
    }

    public LoginModelManager getLoginModelManager(){
        if (loginModelManager==null)
            loginModelManager = new LoginModelManager(cf.getClient());
        return loginModelManager;
    }

    public SignUpModelManager getSignUpModelManager(){
        if (signUpModelManager==null)
            signUpModelManager = new SignUpModelManager(cf.getClient());
        return signUpModelManager;
    }

    public BikeModelManager getBikeModelManager(){
        if (bikeModelManager==null)
            bikeModelManager = new BikeModelManager(cf.getClient());
        return bikeModelManager;
    }

    public BookingModelManager getBookingModelManager(){
        if (bookingModelManager==null)
            bookingModelManager = new BookingModelManager(cf.getClient());
        return bookingModelManager;
    }
}
