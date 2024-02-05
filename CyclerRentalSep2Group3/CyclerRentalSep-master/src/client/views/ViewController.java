package src.client.views;


import src.client.core.ViewHandler;
import src.client.core.ViewModelFactory;

public interface ViewController {
    void init(ViewHandler vh, ViewModelFactory vmf);
}
