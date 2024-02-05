package src.client.models.loginManager;


import src.client.core.ClientFactory;
import src.client.network.Client;
import src.shared.transferobjects.User;

import java.beans.PropertyChangeSupport;

public class LoginModelManager implements LoginModel {
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Client client;
    ClientFactory clientFactory;

    public LoginModelManager(Client client){
        clientFactory = new ClientFactory();
        this.client = clientFactory.getClient();
    }

    public boolean validateLogin(String email, String password){
        return client.validateLogin(email,password);
    }


    public User getUser(String email){
        return client.getUser(email);
    }


}
