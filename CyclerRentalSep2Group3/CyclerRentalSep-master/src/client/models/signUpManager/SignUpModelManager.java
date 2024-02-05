package src.client.models.signUpManager;


import src.client.core.ClientFactory;
import src.client.network.Client;
import src.shared.transferobjects.User;

import java.beans.PropertyChangeSupport;

public class SignUpModelManager implements SignUpModel {
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Client client;
    private ClientFactory clientFactory;

    public SignUpModelManager(Client client){
        clientFactory = new ClientFactory();
        this.client = clientFactory.getClient();
    }

    public boolean signUpUser(User user){
        return client.signUpUser(user);
    }
    public boolean isNewUser(User user){
        return  client.isNewUser(user);
    }

}
