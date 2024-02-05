package src.client.core;

import src.client.views.bikes.BikeViewModel;
import src.client.views.bookings.BookingViewModel;
import src.client.views.login.LoginViewModel;
import src.client.views.signup.SignUpViewModel;

public class ViewModelFactory {

    private final ModelFactory mf;
    // private UppercaseViewModel uppercaseViewModel;LAOD FROM THE VIEWS
    private LoginViewModel loginViewModel;
    private SignUpViewModel signUpViewModel;
    private BikeViewModel bikeViewModel;
    private BookingViewModel bookingViewModel;


    public ViewModelFactory(ModelFactory mf) {
        this.mf = mf;
    }

    public LoginViewModel getLoginViewModel(){
        if (loginViewModel==null)
            loginViewModel = new LoginViewModel(mf.getLoginModelManager());
        return loginViewModel;
    }

    public SignUpViewModel getSignUpViewModel(){
        if (signUpViewModel==null)
            signUpViewModel = new SignUpViewModel(mf.getSignUpModelManager());
        return signUpViewModel;
    }

    public BikeViewModel getBikeViewModel(){
        if (bikeViewModel==null)
            bikeViewModel = new BikeViewModel(mf.getBikeModelManager());
        return bikeViewModel;
    }

    public BookingViewModel getBookingViewModel(){
        if (bookingViewModel==null)
            bookingViewModel = new BookingViewModel(mf.getBookingModelManager());
        return bookingViewModel;
    }

}
