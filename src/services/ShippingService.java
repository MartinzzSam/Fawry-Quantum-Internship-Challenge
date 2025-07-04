package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import classes.CartItem;
import classes.Product;
import config.Configs;
import interfaces.IShippingService;
import interfaces.IShippableProduct;

public class ShippingService implements IShippingService {


    private ArrayList<IShippableProduct> shippableItems;

    public ShippingService(ArrayList<CartItem> cartItems) {
        this.shippableItems = getShippableItems(cartItems);
    }

    @Override
    public void ship(List<IShippableProduct> items) {
        System.out.println("Shipping items: " + items.stream().map(IShippableProduct::getShippingItemDetails).collect(Collectors.joining("\n")));
    }

    @Override
    public double calculateShippingFee() {

        double shippingFee = 0.0;

        for (IShippableProduct item : shippableItems) {
            shippingFee += item.getWeight() * Configs.SHIPPING_FEE_PER_KILOGRAM;
        }
        return shippingFee;
    }

    public ArrayList<IShippableProduct> getShippableItems() {
        return shippableItems;
    }

    private ArrayList<IShippableProduct> getShippableItems(ArrayList<CartItem> cartItems) {
        return cartItems.stream()
                .map(CartItem::getProduct)
                .filter(p -> p instanceof IShippableProduct)
                .map(p -> (IShippableProduct) p)
                .collect(Collectors.toCollection(ArrayList::new));
    }




    
    
    
}
