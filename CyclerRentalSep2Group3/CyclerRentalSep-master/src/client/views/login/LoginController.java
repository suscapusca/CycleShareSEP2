package src.client.views.login;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.client.core.ViewHandler;
import src.client.core.ViewModelFactory;
import src.client.views.ViewController;
import src.shared.BikeHolder;
import src.shared.UserHolder;
import src.shared.transferobjects.User;

import java.io.IOException;

public class LoginController implements ViewController {

    private ViewHandler vh;
    private LoginViewModel viewModel;


    @FXML
    public Button cancelButton;
    @FXML
    public Button loginButton;
    @FXML
    public Label loginMessageLabel;
    @FXML
    public TextField usernameTextField;
    @FXML
    public PasswordField passwordPasswordField;
    @FXML
    public Button registerButton;

    public void cancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void openSignUpView(ActionEvent e) throws IOException {
        vh.openSignUp();
    }

    public void login(ActionEvent e){
        String email = usernameTextField.getText();
        String password = passwordPasswordField.getText();
        if (viewModel.validateLogin(email,password)){
            UserHolder holder = UserHolder.getInstance();
            holder.setUser(viewModel.getUser(email));
            if (viewModel.isCustomer(email)){
                vh.openListBikes();
                System.out.println("customer");
            }
            else if (viewModel.isManager(email)) {
                System.out.println("manager");
                vh.openListBikesManager();
            }
        } else {
            loginMessageLabel.setText("Enter a valid login and password");
        }
    }


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        this.viewModel = vmf.getLoginViewModel();
        loginMessageLabel.textProperty().bindBidirectional(viewModel.getLoginMessageLabel());
    }

}
