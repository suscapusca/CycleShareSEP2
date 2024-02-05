package src.server.model.user;



import src.server.database.dao.user.UserDAOImpl;
import src.shared.transferobjects.User;

import java.util.ArrayList;

public class UserModelManagerImpl implements UserModelManager {

    @Override
    public ArrayList<User> getAllUsers() {
        UserDAOImpl userDAO = new UserDAOImpl();
        return userDAO.getAll();
    }

    public User getUser(String email){
        UserDAOImpl userDAO = new UserDAOImpl();
        return userDAO.get(email);
    }


}
