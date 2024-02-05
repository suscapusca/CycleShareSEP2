package src.server.model.signup;


import src.server.database.dao.user.UserDAOImpl;
import src.shared.transferobjects.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SignupModelManagerImpl implements SignupModelManager {


    @Override
    public boolean isNewUser(User user){
        UserDAOImpl userDAO = new UserDAOImpl();
        return userDAO.get(user.getEmail())==null;
    }

    @Override
    public boolean signUpUser(User user) {
        UserDAOImpl userDAO = new UserDAOImpl();
        if(userDAO.insert(user))
            return true;
        else
            return false;
        }
}
