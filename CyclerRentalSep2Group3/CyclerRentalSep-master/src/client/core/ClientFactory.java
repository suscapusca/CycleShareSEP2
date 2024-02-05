package src.client.core;


import src.client.network.Client;
import src.client.network.RMIClient;

public class ClientFactory {
    private Client client;

    public Client getClient() {
        if(client == null) {
            client = new RMIClient();
            client.startClient();
        }
        return client;
    }
}
