package src.client.views.bikes.updateBike;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import src.client.core.ViewHandler;
import src.client.core.ViewModelFactory;
import src.client.views.ViewController;
import src.client.views.bikes.BikeViewModel;
import src.shared.BikeHolder;
import src.shared.transferobjects.Bike;

public class EditBikeController implements ViewController {
    @FXML
    TextField brand;
    @FXML
    TextField category;
    @FXML
    TextField availability;
    @FXML
    TextField year;
    @FXML
    TextField price;

    private ViewHandler vh;
    private BikeViewModel vm;
    private Bike bike;
    private BikeHolder holder;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        vm = vmf.getBikeViewModel();
        holder = holder.getInstance();
        bike = holder.getBike();
        brand.setText(holder.getBike().getBrand());
        category.setText(holder.getBike().getCategory());
        year.setText(String.valueOf(holder.getBike().getYear()));
        price.setText(String.valueOf(holder.getBike().getPrice()));
        availability.setText(String.valueOf(holder.getBike().isAvailability()));
    }

    public void backPreviousScene(MouseEvent mouseEvent) {
        vh.openListBikesManager();
    }

    public void submitChanges(ActionEvent actionEvent) {
        boolean a = false;
        int y = Integer.parseInt(year.getText());
        float p = Float.parseFloat(price.getText());

        if (availability.getText().equals("0") || availability.getText().equals("false"))
            a = false;
        else if(availability.getText().equals("1") || availability.getText().equals("true"))
            a = true;

        vm.updateBike(new Bike(brand.getText(), category.getText(), a, y, p), holder.getBike().getId());
        vh.openListBikesManager();
    }

}
