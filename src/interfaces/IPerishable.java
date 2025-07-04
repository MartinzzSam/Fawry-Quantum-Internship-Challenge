package interfaces;

import java.time.LocalDate;

public interface IPerishable {
    
    boolean isExpired();

    LocalDate getExpirationDate();
}