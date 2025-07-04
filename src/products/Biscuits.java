package products;

import java.time.LocalDate;

import classes.Product;
import config.Configs;
import interfaces.IPerishable;
import interfaces.IShippableProduct;

public class Biscuits extends Product implements IPerishable, IShippableProduct {

    LocalDate expirationDate;

    public Biscuits(String name, double price, int quantity, LocalDate expirationDate) {
        super(Configs.BISCUITS_ID, name, price, quantity);
        this.expirationDate = expirationDate;
    }

    @Override
    public LocalDate getExpirationDate() {
        return LocalDate.now().plusDays(30);
    }

    @Override
    public boolean isExpired() {
        return getExpirationDate().isBefore(LocalDate.now());
    }

    @Override
    public double getWeight() {
        return Configs.BISCUITS_WEIGHT;
    }

    @Override
    public String getShippingItemDetails() {
        return  this.getName() + "\n" + "Weight: " + this.getWeight() + " g";
    }
}