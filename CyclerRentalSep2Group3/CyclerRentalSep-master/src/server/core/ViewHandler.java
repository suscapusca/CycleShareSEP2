package src.server.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    private ViewModelFactory viewModelFactory;
    private Stage mainStage;
    private Scene logScene;

    public ViewHandler(ViewModelFactory vmf){this.viewModelFactory= vmf;}

    public void start(){
        mainStage = new Stage();
    }
}
