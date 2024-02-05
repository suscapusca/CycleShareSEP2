package src.client.views.bookings.manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import src.client.core.ViewHandler;
import src.client.core.ViewModelFactory;
import src.client.views.ViewController;
import src.client.views.bookings.BookingViewModel;
import src.shared.BikeHolder;
import src.shared.BookingHolder;
import src.shared.transferobjects.Booking;

import java.util.ArrayList;

public class ManagerListBookingsController implements ViewController {

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
        bookingsToLoad.addAll(bookings);
        return bookingsToLoad;
    }


    public void openEditBooking(ActionEvent actionEvent) {
        BookingHolder holder = BookingHolder.getInstance();
        selectedBooking = selectionModel.getSelectedItem();
        holder.setBooking(selectedBooking);
        vh.openEditBooking();
    }

    public void refresh(ActionEvent event){
        refreshTable();
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

    public void back(ActionEvent actionEvent) {
        vh.openListBikesManager();
    }
}
