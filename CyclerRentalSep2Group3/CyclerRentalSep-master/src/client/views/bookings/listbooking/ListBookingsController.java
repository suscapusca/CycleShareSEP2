package src.client.views.bookings.listbooking;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import src.client.core.ViewHandler;
import src.client.core.ViewModelFactory;
import src.client.views.ViewController;
import src.client.views.bookings.BookingViewModel;
import src.shared.BookingHolder;
import src.shared.UserHolder;
import src.shared.transferobjects.Booking;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ListBookingsController implements ViewController {

    @FXML
    private TableView<Booking> tableView;
    public TableColumn<String, Booking> id;
    public TableColumn<String, Booking> customerid;
    public TableColumn<String, Booking> bikeid;
    public TableColumn<String, Booking> startingdate;
    public TableColumn<String, Booking> enddate;
    public TableColumn<String, Booking> finalprice;


    private ViewHandler vh;
    private BookingViewModel viewModel;
    private TableView.TableViewSelectionModel<Booking> selectionModel;
    private Booking selectedBooking;
    private UserHolder userHolder = UserHolder.getInstance();


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        this.viewModel = vmf.getBookingViewModel();
        tableView.setItems(loadBooking());
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        customerid.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        bikeid.setCellValueFactory(new PropertyValueFactory<>("bikeId"));
        startingdate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        enddate.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        finalprice.setCellValueFactory(new PropertyValueFactory<>("finalPrice"));
        selectionModel = tableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
    }

    public ObservableList<Booking> loadBooking(){
        ObservableList<Booking> bookingsToLoad = FXCollections.observableArrayList();
        ArrayList<Booking> bookings =  viewModel.getBookings();
        bookings.forEach((c)->{
            if(c.getCustomerId()== userHolder.getUser().getId())
                bookingsToLoad.add(c);
        });
        return bookingsToLoad;
    }


    public void refreshTable(){
        tableView.setItems(loadBooking());
        tableView.refresh();
    }

    public void deleteBooking(ActionEvent event) {
        BookingHolder holder = BookingHolder.getInstance();
        selectedBooking = selectionModel.getSelectedItem();
        holder.setBooking(selectedBooking);
        viewModel.deleteBooking(holder.getBooking());
        refreshTable();
    }
    public void back(ActionEvent event){
        vh.openListBikes();
    }


}
