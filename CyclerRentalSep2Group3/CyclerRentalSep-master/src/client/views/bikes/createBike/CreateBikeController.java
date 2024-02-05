package src.client.views.bikes.createBike;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import src.client.core.ViewHandler;
import src.client.core.ViewModelFactory;
import src.client.views.ViewController;
import src.client.views.bikes.BikeViewModel;
import src.client.views.login.LoginViewModel;
import src.shared.transferobjects.Bike;

import java.sql.SQLException;

public class CreateBikeController implements ViewController {
    public Button backButton;
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

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        vm = vmf.getBikeViewModel();
    }

    public void backPreviousScene(MouseEvent mouseEvent) {
        vh.openListBikesManager();
    }

    public void createBike(ActionEvent actionEvent) throws SQLException {
        boolean a = false;
        int y = Integer.parseInt(year.getText());
        float p = Float.parseFloat(price.getText());

        if (availability.getText().equals("0") || availability.getText().equals("false"))
            a = false;
        else if(availability.getText().equals("1") || availability.getText().equals("true"))
            a = true;

        vm.createBike(new Bike(brand.getText(), category.getText(), a,y,p));
        vh.openListBikesManager();
    }

}
