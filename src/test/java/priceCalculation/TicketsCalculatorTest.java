package priceCalculation;



import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.List;


public class TicketsCalculatorTest {
    private TicketsCalculator calculator = new TicketsCalculator();

    @Test
    public void simpleTicketCalculationCheck() {

        Tickets tickets = new Tickets("Vilnius", 10.0);
        Assert.assertEquals("Vilnius", tickets.getDestination(), "Allert: Destination");

    }

    @Test
    public void multipleTicketsCalculationCheck() {
        TicketsObject ticketsObjectAdult = new TicketsObject();
        TicketsSubObject ticketsSubObjectAdult = new TicketsSubObject(TicketTypes.ADULT, 10.0, 2);
        TicketsSubObject ticketsSubObjectChild = new TicketsSubObject(TicketTypes.CHILD, 10.0, 1);

        ticketsObjectAdult.setTicketsSubObjects(List.of(ticketsSubObjectAdult, ticketsSubObjectChild));

        double realAdultTicketPrice = PriceCalculation.makePassengerTicketPrice(10.0, "Vilnius", 0.21, TicketTypes.ADULT, null);
        double ticketPriceAdult = 10.0 + (10.0 * 0.21);
        Assert.assertEquals(ticketPriceAdult, realAdultTicketPrice, "Allert: adult ticket");

        double realAdultBaggageTicketPrice = PriceCalculation.makeBaggagePrice(TicketTypes.ADULT, ticketsSubObjectAdult.getBaggageCount(), ticketsSubObjectAdult.getBaggagePrice(), 0.3, 0.21);
        Assert.assertEquals(7.26, realAdultBaggageTicketPrice, "Allert: adult baggage ticket");

        double realChildTicketPrice = PriceCalculation.makePassengerTicketPrice(10.0, "Vilnius", 0.21, TicketTypes.CHILD, 0.5);
        Assert.assertEquals(6.05, realChildTicketPrice, "Allert: child ticket");

        double realChildBaggageTicketPrice = PriceCalculation.makeBaggagePrice(TicketTypes.CHILD, ticketsSubObjectChild.getBaggageCount(), ticketsSubObjectChild.getBaggagePrice(), 0.3, 0.21);
        Assert.assertEquals(3.63, realChildBaggageTicketPrice, "Allert: child baggage ticket");
    }
}