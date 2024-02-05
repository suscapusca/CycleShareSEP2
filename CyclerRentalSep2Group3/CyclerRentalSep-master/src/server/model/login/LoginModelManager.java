package src.server.model.login;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface LoginModelManager {
    boolean validateLogin(String email, String passwordPasswordField ) ;
    void getUser(String usernameTextField, String passwordPasswordField);
}
