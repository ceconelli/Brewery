package models;


import java.sql.Date;

/**
 *
 * @author gceconelli
 */
public class Order {
    
    private Client client;
    private Beer beer;
    private double amount;
    private double price;
    private Date date;
    private boolean delivered;

    public Order(Client client, Beer beer, double amount, double price, Date date, boolean delivered) {
        this.client = client;
        this.beer = beer;
        this.amount = amount;
        this.price = price;
        this.date = date;
        this.delivered = delivered;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    @Override
    public String toString() {
        return "Order{" + "client=" + client + ", beer=" + beer + ", amount=" + amount + ", price=" + price + ", date=" + date + ", delivered=" + delivered + '}';
    }
    
    
    
}
