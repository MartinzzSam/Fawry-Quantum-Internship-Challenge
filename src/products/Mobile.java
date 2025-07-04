package products;

import classes.Product;
import config.Configs;
import interfaces.IShippableProduct;

public class Mobile extends Product implements IShippableProduct {

    public Mobile(String name, double price, int quantity) {
        super( Configs.MOBILE_ID, name, price, quantity);
    }
    

    @Override
    public double getWeight() {
        return Configs.MOBILE_WEIGHT;
    }


    @Override
    public String getShippingItemDetails() {
        return  this.getName() + "\n" + "Weight: " + this.getWeight() + "kg";
    }





    
}