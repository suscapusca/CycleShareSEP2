package src.client.views.signup;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import src.client.core.ViewHandler;
import src.client.core.ViewModelFactory;
import src.client.views.ViewController;
import src.shared.transferobjects.User;

import java.io.IOException;
import java.util.ArrayList;

public class SignupController implements ViewController {

    private ViewHandler vh;
    private SignUpViewModel viewModel;

    @FXML
    public Button buttonSignup;
    @FXML
    public Button buttonCancel;
    @FXML
    public Button buttonLogin;
    @FXML
    public Label loginMessageLabel;
    @FXML
    public TextField textFieldName;
    @FXML
    public TextField textFieldSurname;
    @FXML
    public TextField textFieldEmail;

    @FXML
    public PasswordField passwordFieldPassword;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        this.viewModel = vmf.getSignUpViewModel();
        loginMessageLabel.textProperty().bindBidirectional(viewModel.getLoginMessageLabel());
    }

    public void openLoginView(ActionEvent event) throws IOException {
        vh.openLogin();
    }

    public User loadUser() {
        String email = textFieldEmail.getText();
        String password = passwordFieldPassword.getText();
        String name = textFieldName.getText();
        String phonenumber = textFieldSurname.getText();
        String userType = "Customer";
        return new User(name, email, phonenumber, password, userType);
    }

    public void signUp(ActionEvent event) throws IOException {
        if (viewModel.isNewUser(loadUser())) {
            if (!viewModel.signUpUser(loadUser())) {
                Alert registrationSuccessful = new Alert(Alert.AlertType.CONFIRMATION);
                registrationSuccessful.setContentText(textFieldEmail.getText() + " You have registered");
                registrationSuccessful.show();
                vh.openLogin();
            }
        } else {
            Alert registrationSuccessful = new Alert(Alert.AlertType.INFORMATION);
            registrationSuccessful.setContentText(textFieldEmail.getText() + " Is already in use!");
            registrationSuccessful.show();
        }
    }

    public void quitApplication(ActionEvent event) {
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
    }
}


