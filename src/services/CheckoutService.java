package services;

import java.util.ArrayList;

import classes.CartItem;
import classes.Customer;
import classes.Product;
import interfaces.IShippableProduct;

public class CheckoutService {

    private Customer customer;
    private ArrayList<CartItem> cartItems;
    private ShippingService shippingService;
    private ArrayList<IShippableProduct> shippableItems;

    public CheckoutService(ArrayList<CartItem> cartItems, ShippingService shippingService, Customer customer) {
        this.customer = customer;
        this.cartItems = cartItems;
        this.shippingService = shippingService;
        this.shippableItems = shippingService.getShippableItems();
    }

    public void checkout() {
        double total = 0;
        for (CartItem cartItem : cartItems) {
            total += cartItem.getProduct().getPrice() * cartItem.getQuantity();
        }

        if (total > customer.getBalance()) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        customer.deductBalance(total);


        //Print Invoice
        this.printInvoice();

        //Ship Products
        if (!shippableItems.isEmpty()) {
            shippingService.ship();
        }

    }

    private void printInvoice() {

        // Shipment notice
        if (!shippableItems.isEmpty()) {
            System.out.println("** Shipment notice **");

            for (CartItem cartItem : cartItems) {
                Product product = cartItem.getProduct();
                int quantity = cartItem.getQuantity();
                if (product instanceof IShippableProduct) {
                    IShippableProduct shippable = (IShippableProduct) product;
                    double totalWeight = shippable.getWeight() * quantity;
                    System.out.println(quantity + "x " + product.getName() + " " +
                            totalWeight + " g");
                }
            }

            double totalWeight = shippableItems.stream()
                    .mapToDouble(IShippableProduct::getWeight)
                    .sum();

            System.out.println("Total package weight " + totalWeight / 1000 + " kg");
        }

        // Checkout receipt
        System.out.println("** Checkout receipt **");

        for (CartItem cartItem : cartItems) {
            Product product = cartItem.getProduct();
            int quantity = cartItem.getQuantity();
            double itemTotal = product.getPrice() * quantity;
            System.out.println(quantity + "x " + product.getName() + " " + (int) itemTotal);
        }

        double subtotal = cartItems.stream()
                .mapToDouble(cartItem -> cartItem.getProduct().getPrice() * cartItem.getQuantity())
                .sum();

        double shippingFee = shippingService.calculateShippingFee();

        double totalAmount = subtotal + shippingFee;

        System.out.println("----------------------");
        System.out.println("Subtotal " + (int) subtotal);
        System.out.println("Shipping " + (int) shippingFee);
        System.out.println("Amount " + (int) totalAmount);
        System.out.println("END.");
    }

    // ** Shipment notice **
    // 2x Cheese 400g
    // 1x Biscuits 700g
    // Total package weight 1.1kg
    // ** Checkout receipt **
    // 2x Cheese 200
    // 1x Biscuits 150
    // ----------------------
    // Subtotal 350
    // Shipping 30
    // Amount 380

  
}
