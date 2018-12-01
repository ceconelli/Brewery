package models;

/**
 *
 * @author gceconelli
 */
public class Stock {

    private Beer beer;
    private double amount;

    public Stock(Beer beer, double amount) {
        this.beer = beer;
        this.amount = amount;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
    
    
}
