package src.server;

import src.server.network.RMIServerImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        RMIServerImpl server = new RMIServerImpl();

        server.startServer();
        System.out.println("Server is running ....");

    }
}
