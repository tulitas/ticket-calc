package priceCalculation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tickets {
    public Tickets(){

    }
    private String destination;
    private Double price;

    public Tickets(String destination, Double price){
            this.destination = destination;
            this.price = price;
    }

}
