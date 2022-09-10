package priceCalculation;

public class PriceCalculation {
    public  static Double makePassengerTicketPrice(Double ticketPrice, String destination, Double vat, TicketTypes name, Double childTicketDiscount) {
        Double price = null;
        if (name.equals(TicketTypes.ADULT) && destination.equals("Vilnius")) {
            price = ticketPrice + (ticketPrice * vat);
          TicketsCalculator.adultTicketPriceOneWay = price;
        } else if (name.equals(TicketTypes.CHILD) && destination.equals("Vilnius")){
            price = (ticketPrice * childTicketDiscount + ticketPrice * childTicketDiscount * vat);
        }
        TicketsCalculator.childTicketPriceOneWay = price;
        return price;
    }

    public static Double makeBaggagePrice(TicketTypes type, int baggageCount, Double baggageTicketPrice, Double baggageDiscount, Double vat) {
        Double price = null;
        if (type.equals(TicketTypes.ADULT)){
            price = ((baggageCount * baggageTicketPrice * baggageDiscount) + (baggageCount * baggageTicketPrice * baggageDiscount * vat));
            TicketsCalculator.adultBaggageTicketPriceOneWay = price;
        }else  if (type.equals(TicketTypes.CHILD)){
            price = ((baggageCount * baggageTicketPrice * baggageDiscount) + (baggageCount * baggageTicketPrice * baggageDiscount * vat));
            TicketsCalculator.childBaggageTicketPriceOneWay = price;
        }
        return price;
    }
}
