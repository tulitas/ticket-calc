package priceCalculation;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TicketsObject {
    private String adultTicketName;
    private String childTicketName;
    private TicketTypes ticketType;
    private Double adultTicketPrice;
    private Double childTicketPrice;
    private List<TicketsSubObject> ticketsSubObjects;

}
