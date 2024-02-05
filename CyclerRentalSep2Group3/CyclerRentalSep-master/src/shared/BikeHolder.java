package src.shared;

import src.shared.transferobjects.Bike;

public final class BikeHolder {

    private Bike bike;
    private final static BikeHolder INSTANCE = new BikeHolder();

    private BikeHolder() {}

    public static BikeHolder getInstance() {
        return INSTANCE;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }
}