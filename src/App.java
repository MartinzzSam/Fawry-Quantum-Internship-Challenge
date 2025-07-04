import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import classes.Customer;
import products.Biscuits;
import products.Mobile;
import products.MobileScratchCard;
import products.TV;
import services.CartService;
import services.CheckoutService;
import services.InventoryService;
import services.ShippingService;
import products.Cheese;

public class App {
    public static void main(String[] args) throws Exception {

        //Configs Contain All Weights and IDs of Products
        

        //Define Customer
        Customer customer = new Customer("Ahmed Ali", 10000);


        // Define Inventory
        InventoryService inventory = new InventoryService(new ArrayList<>(Arrays.asList(
            new TV("TV", 1000, 2),
            new Mobile("Mobile", 1000, 3),
            new MobileScratchCard("Mobile Scratch Card", 1000, 4),
            new Biscuits("Biscuits", 1000, 5, LocalDate.of(2026, 1, 1)),
            new Cheese("Cheese", 1000, 6, LocalDate.of(2026, 1, 1)))));

        // Cart Service
        CartService cartService = new CartService(inventory.getInventoryProducts());


        // Add Products To Cart
        cartService.add(inventory.getProduct(1), 2);
        cartService.add(inventory.getProduct(2), 3);
        cartService.add(inventory.getProduct(3), 1);
        cartService.add(inventory.getProduct(4), 1);
        cartService.add(inventory.getProduct(5), 1);


    
        // Shipping Service
        ShippingService shippingService = new ShippingService(cartService.getCartItems());
        

        // Checkout
        CheckoutService checkoutService = new CheckoutService(cartService.getCartItems(), shippingService, customer);
        checkoutService.checkout();
    }



    
}
