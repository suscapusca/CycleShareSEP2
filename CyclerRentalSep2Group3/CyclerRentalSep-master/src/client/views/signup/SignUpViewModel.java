package src.client.views.signup;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import src.client.models.signUpManager.SignUpModelManager;
import src.shared.transferobjects.User;


public class SignUpViewModel {
    private SignUpModelManager signUpModelManager;

    public SignUpViewModel(SignUpModelManager signUpModelManager) {
        this.signUpModelManager= signUpModelManager;
        loginMessageLabel = new SimpleStringProperty();}

    private StringProperty loginMessageLabel;

    public boolean signUpUser(User user){
        return signUpModelManager.signUpUser(user);
    }

    public boolean isNewUser(User user){
        return signUpModelManager.isNewUser(user);
    }




    StringProperty getLoginMessageLabel() {
        return loginMessageLabel;
    }



}
