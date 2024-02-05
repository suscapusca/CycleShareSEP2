package src.server.model.login;

import src.server.database.dao.user.UserDAO;
import src.server.database.dao.user.UserDAOImpl;
import src.shared.transferobjects.User;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;


public class LoginModelManagerImpl implements LoginModelManager {
    private PropertyChangeSupport support;

    @Override
    public boolean validateLogin(String email, String passwordPasswordField ){
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = new User(userDAO.get(email));
        if (user.getPassword().equals(passwordPasswordField)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void getUser(String usernameTextField, String passwordPasswordField){

    }
}
