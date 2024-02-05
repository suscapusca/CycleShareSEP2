package src.client;

import javafx.application.Application;
import javafx.stage.Stage;
import src.client.core.ClientFactory;
import src.client.core.ModelFactory;
import src.client.core.ViewHandler;
import src.client.core.ViewModelFactory;

public class CyclerRentalApp extends Application {
    private ClientFactory cf;

    @Override
    public void start(Stage stage) throws Exception {
        cf = new ClientFactory();
        ModelFactory mf = new ModelFactory(cf);
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(vmf);
        vh.start();
    }
}
