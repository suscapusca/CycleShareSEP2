package src.shared.transferobjects;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable {
    private int id;
    private int customerId;
    private int bikeId;
    private Date startDate;
    private Date endDate;
    private float finalPrice;

    public Booking(int customerId, int bikeId, Date startDate, Date endDate, float finalPrice) {
        this.customerId = customerId;
        this.bikeId = bikeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.finalPrice = finalPrice;
    }

    public Booking(int id, int customerId, int bikeId, Date startDate, Date endDate, float finalPrice) {
        this.id = id;
        this.customerId = customerId;
        this.bikeId = bikeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.finalPrice = finalPrice;
    }

    public Booking(int i, int i1, int i2, int i3, double v, int i4, int i5, int i6, int i7, int i8, int i9) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }
}
