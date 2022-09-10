package priceCalculation;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TicketsObject {
    private String adultTicketName;
    private String childTicketName;
    private TicketTypes ticketType;
    private Double adultTicketPrice;
    private Double childTicketPrice;
}
