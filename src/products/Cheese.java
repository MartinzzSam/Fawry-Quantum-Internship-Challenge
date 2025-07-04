package products;

import java.time.LocalDate;

import classes.Product;
import config.Configs;
import interfaces.IPerishable;
import interfaces.IShippableProduct;

public class Cheese extends Product implements IPerishable, IShippableProduct {
    LocalDate expirationDate;

    double weight = Configs.CHEESE_WEIGHT;

    public Cheese( String name, double price, int quantity, LocalDate expirationDate) {
        super(Configs.CHEESE_ID, name, price, quantity);
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() { return expirationDate; }

    public boolean isExpired() {
        return expirationDate.isBefore(LocalDate.now()); }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String getShippingItemDetails() {
        return  this.getName() + "\n" + "Weight: " + this.getWeight() + " g";
    }



}