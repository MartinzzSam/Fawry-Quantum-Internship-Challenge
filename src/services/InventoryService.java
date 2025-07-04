package services;

import java.util.ArrayList;

import classes.Product;

public class InventoryService {

    ArrayList<Product> inventory;

    public InventoryService(ArrayList<Product> inventory) {
        this.inventory = inventory;
    }
    

    public Product getProduct(int id) {
        return inventory.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }


    public ArrayList<Product> getInventoryProducts() {
        return inventory;
    }
    
    
}
