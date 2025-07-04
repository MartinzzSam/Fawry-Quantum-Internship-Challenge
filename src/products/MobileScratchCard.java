package products;

import classes.Product;
import config.Configs;

public class MobileScratchCard extends Product {

    public MobileScratchCard(String name, double price, int quantity) {
        super(Configs.MOBILE_SCRATCH_CARD_ID, name, price, quantity);
    }
    
}