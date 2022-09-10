package priceCalculation;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TicketsSubObject {
    private TicketTypes types;
    private Double baggagePrice;
    private int baggageCount;

}
