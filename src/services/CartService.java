package services;

import java.util.ArrayList;

import classes.CartItem;
import classes.Product;
import interfaces.IPerishable;

public class CartService {
    private ArrayList<CartItem> cartItems;

    ArrayList<Product> inventory;




    public CartService(ArrayList<Product> inventory) {
        this.cartItems = new ArrayList<>();
        this.inventory = inventory;

    }

    public void add(Product product, int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        if (!isExistsAtInventory(product)) {
            throw new IllegalArgumentException("Product " + product.getName() + " not found in inventory");
        }

        if(isOutOfStock(product, quantity)) { 
            throw new IllegalArgumentException("Not enough quantity of " + product.getName() + " in inventory");
        }

        if(isExpired(product)) {
            throw new IllegalArgumentException("Product " + product.getName() + " is expired");
        }

        cartItems.add(new CartItem(product, quantity));
    }

    public ArrayList<CartItem> getCartItems() { return cartItems; }


    private boolean isExpired(Product product) {
        if(product instanceof IPerishable) {
            return ((IPerishable) product).isExpired();
        }
        return false;
    }

    private boolean isOutOfStock(Product product, int quantity) {
        return inventory.stream().filter(p -> p.getId() == product.getId()).findFirst().get().getQuantity() < quantity;
    }

    private boolean isExistsAtInventory(Product product) {
        return inventory.stream().anyMatch(p -> p.getId() == product.getId());
    }
}