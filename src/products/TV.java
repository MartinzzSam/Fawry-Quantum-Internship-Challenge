package products;

import classes.Product;
import config.Configs;
import interfaces.IShippableProduct;

public class TV extends Product implements IShippableProduct {

    public TV(String name, double price, int quantity) {
        super(Configs.TV_ID, name, price, quantity);
    }
    

    @Override
    public double getWeight() {
        return Configs.TV_WEIGHT;
    }

    @Override
    public String getShippingItemDetails() {
        return  this.getName() + "\n" + "Weight: " + this.getWeight() + "kg";
    }





    
}