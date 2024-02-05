package src.client.views.bookings.createBooking;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import src.client.core.ViewHandler;
import src.client.core.ViewModelFactory;
import src.client.views.ViewController;
import src.client.views.bikes.BikeViewModel;
import src.client.views.bookings.BookingViewModel;
import src.shared.BikeHolder;
import src.shared.UserHolder;
import src.shared.transferobjects.Bike;
import src.shared.transferobjects.Booking;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateBookingController implements ViewController {
    @FXML
    TextField customerId;
    @FXML
    TextField bikeId;
    @FXML
    TextField startDate;
    @FXML
    TextField endDate;
    @FXML
    TextField finalPrice;

    private ViewHandler vh;
    private BookingViewModel vm;
    private BikeHolder bikeHolder = BikeHolder.getInstance();
    private UserHolder userHolder = UserHolder.getInstance();

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        vm = vmf.getBookingViewModel();
        bikeId.setText(String.valueOf(bikeHolder.getBike().getId()));
        customerId.setText(String.valueOf(userHolder.getUser().getId()));
    }

    public void backPreviousScene(ActionEvent actionEvent) {
        vh.openListBikes();
    }

    public void createBooking(ActionEvent actionEvent) throws SQLException, ParseException {
        int ci = Integer.parseInt(customerId.getText());
        int bi = Integer.parseInt(bikeId.getText());
        float fp = Float.parseFloat(finalPrice.getText());
        Date sd = new SimpleDateFormat("yyyy-MM-dd").parse(startDate.getText());
        Date ed = new SimpleDateFormat("yyyy-MM-dd").parse(endDate.getText());

        vm.createBooking(new Booking(ci, bi, sd, ed, fp));
        vh.openListBikes();
    }

}
