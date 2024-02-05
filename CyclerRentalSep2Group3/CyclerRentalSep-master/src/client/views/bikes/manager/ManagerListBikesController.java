package src.client.views.bikes.manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import src.client.core.ViewHandler;
import src.client.core.ViewModelFactory;
import src.client.views.ViewController;
import src.client.views.bikes.BikeViewModel;
import src.shared.BikeHolder;
import src.shared.transferobjects.Bike;

import java.util.ArrayList;

public class ManagerListBikesController implements ViewController {

    @FXML
    private TableView<Bike> tableView;
    public TableColumn<String, Bike> id;
    public TableColumn<String, Bike> brand;
    public TableColumn<String, Bike> category;
    public TableColumn<String, Bike> availability;
    public TableColumn<String, Bike> year;
    public TableColumn<String, Bike> price;
    public ImageView backButton;

    private ViewHandler vh;
    private BikeViewModel viewModel;
    private TableView.TableViewSelectionModel<Bike> selectionModel;
    private Bike selectedBike;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        this.viewModel = vmf.getBikeViewModel();
        tableView.setItems(loadBikes());
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        availability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        selectionModel = tableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
    }

    public ObservableList<Bike> loadBikes(){
        ObservableList<Bike> bikesToLoad = FXCollections.observableArrayList();
        ArrayList<Bike> bikes =  viewModel.getBikes();
        bikesToLoad.addAll(bikes);
        return bikesToLoad;
    }

    public void openCreateBike(ActionEvent actionEvent) {
        vh.openCreateBike();
    }

    public void openEditBike(ActionEvent actionEvent) {
        BikeHolder holder = BikeHolder.getInstance();
        selectedBike = selectionModel.getSelectedItem();
        holder.setBike(selectedBike);
        System.out.println(holder.getBike().getBrand());
        vh.openEditBike();
    }

    public void refresh(ActionEvent event){
        refreshTable();
    }

    public void refreshTable(){
        tableView.setItems(loadBikes());
        tableView.refresh();
    }

    public void deleteBike(ActionEvent event) {
        BikeHolder holder = BikeHolder.getInstance();
        selectedBike = selectionModel.getSelectedItem();
        holder.setBike(selectedBike);
        viewModel.deleteBike(holder.getBike());
        refreshTable();
    }

    public void logOut(ActionEvent event) {
        vh.openLogin();
    }

    public void seeBookingsOverview(ActionEvent actionEvent) {
        vh.openListBookingManager();
    }
}
