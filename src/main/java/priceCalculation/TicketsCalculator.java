package priceCalculation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketsCalculator {
    public static Double adultTicketPriceOneWay;
    public static Double adultBaggageTicketPriceOneWay;
    public static Double childTicketPriceOneWay;
    public static Double childBaggageTicketPriceOneWay;

    public static void main(String[] args) {
        calculate(new Tickets());
    }

    public static void calculate(Tickets tickets) {
        tickets.setPrice(10.0);
        tickets.setDestination("Vilnius");

        final Double vat = 0.21;
        final Double baggageDiscount = 0.3;
        final Double childTicketDiscount = 0.5;
        final int adultBaggageCount = 2;
        final int childBaggageCount = 1;

        TicketsObject ticketObject = new TicketsObject();
        TicketsSubObject ticketsSubObject = new TicketsSubObject();

        ticketObject.setTicketType(TicketTypes.ADULT);
        ticketObject.setAdultTicketPrice(PriceCalculation.makePassengerTicketPrice(tickets.getPrice(),
                tickets.getDestination(), vat, ticketObject.getTicketType(), null));
        ticketsSubObject.setTypes(TicketTypes.ADULT);
        ticketsSubObject.setBaggageCount(adultBaggageCount);
        ticketsSubObject.setBaggagePrice(PriceCalculation.makeBaggagePrice(TicketTypes.ADULT, adultBaggageCount, tickets.getPrice(), baggageDiscount, vat));

        ticketObject.setTicketType(TicketTypes.CHILD);
        ticketObject.setChildTicketPrice(PriceCalculation.makePassengerTicketPrice(tickets.getPrice(),
                tickets.getDestination(), vat, ticketObject.getTicketType(), childTicketDiscount));
        ticketsSubObject.setTypes(TicketTypes.CHILD);
        ticketsSubObject.setBaggagePrice(PriceCalculation.makeBaggagePrice(TicketTypes.CHILD, childBaggageCount, tickets.getPrice(), baggageDiscount, vat));
        double summ = adultTicketPriceOneWay + adultBaggageTicketPriceOneWay + childTicketPriceOneWay + childBaggageTicketPriceOneWay;
        System.out.println("Adult ticket price is: " + adultTicketPriceOneWay + "\n"
                + "Adult baggage ticket price is: " + adultBaggageTicketPriceOneWay + "\n"
                + "Child ticket price is: " + childTicketPriceOneWay + "\n"
                + "Child baggege ticket price is: " + childBaggageTicketPriceOneWay + "\n"
        + "Summ by all tickets is: " + summ);
    }
}
