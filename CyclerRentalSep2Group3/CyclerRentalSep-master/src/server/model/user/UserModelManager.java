package src.server.model.user;


import src.shared.transferobjects.User;

import java.util.ArrayList;

public interface UserModelManager {
    ArrayList<User> getAllUsers();
    User getUser(String email);
}
