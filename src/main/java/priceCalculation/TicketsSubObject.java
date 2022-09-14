package priceCalculation;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TicketsSubObject {
    private TicketTypes types;
    private Double baggagePrice;
    private int baggageCount;

    public TicketsSubObject(TicketTypes type, Double price, int count) {
        this.types = type;
        this.baggagePrice = price;
        this.baggageCount = count;
    }

    public TicketsSubObject() {

    }
}
