package interfaces;

import java.util.List;

public interface IShippingService {
    void ship(List<IShippableProduct> items);
    double calculateShippingFee();
}