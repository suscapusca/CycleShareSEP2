package src.client.views.login;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import src.client.models.loginManager.LoginModelManager;
import src.shared.transferobjects.User;


public class LoginViewModel {
    private LoginModelManager loginModelManager;


    public LoginViewModel(LoginModelManager loginModelManager){
        this.loginModelManager = loginModelManager;
        loginMessageLabel = new SimpleStringProperty();
    }

    public boolean isCustomer(String email){
        User user = loginModelManager.getUser(email);
        return user.getUserType().equals("Customer");
    }

    public boolean isManager(String email){
        User user = loginModelManager.getUser(email);
        return user.getUserType().equals("Manager");
    }


    public  boolean validateLogin(String email, String password){
        return loginModelManager.validateLogin(email,password);

    }

    public User getUser(String email){
        return loginModelManager.getUser(email);
    }

    private StringProperty loginMessageLabel;

    StringProperty getLoginMessageLabel(){
        return loginMessageLabel;
    }

}
