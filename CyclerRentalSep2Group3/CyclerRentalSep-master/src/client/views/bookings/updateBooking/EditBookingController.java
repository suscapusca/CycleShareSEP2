package src.client.views.bookings.updateBooking;

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
import src.shared.BookingHolder;
import src.shared.transferobjects.Bike;
import src.shared.transferobjects.Booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditBookingController implements ViewController {
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
    private Booking booking;
    private BookingHolder holder;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        vm = vmf.getBookingViewModel();
        holder = holder.getInstance();
        booking = holder.getBooking();
        customerId.setText(String.valueOf(holder.getBooking().getCustomerId()));
        bikeId.setText(String.valueOf(holder.getBooking().getBikeId()));
        startDate.setText(String.valueOf(holder.getBooking().getStartDate()));
        endDate.setText(String.valueOf(holder.getBooking().getEndDate()));
        finalPrice.setText(String.valueOf(holder.getBooking().getFinalPrice()));
    }

    public void back(ActionEvent actionEvent) {
        vh.openListBookingManager();
    }

    public void submitChanges(ActionEvent actionEvent) throws ParseException {
        int ci = Integer.parseInt(customerId.getText());
        int bi = Integer.parseInt(bikeId.getText());
        float fp = Float.parseFloat(finalPrice.getText());
        Date sd = new SimpleDateFormat("yyyy-MM-dd").parse(startDate.getText());
        Date ed = new SimpleDateFormat("yyyy-MM-dd").parse(endDate.getText());

        vm.updateBooking(new Booking(ci, bi, sd, ed, fp), holder.getBooking().getId());
        vh.openListBookingManager();
    }

}
