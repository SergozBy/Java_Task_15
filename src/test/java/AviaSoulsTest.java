import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    // test Ticket compare to
    @Test
    public void shouldCompareTicketsByPrice() {
        Ticket t1 = new Ticket("LON", "BER", 10, 1000, 1200);
        Ticket t2 = new Ticket("LON", "BER", 20, 1000, 1200);
        Ticket t3 = new Ticket("LON", "BER", 10, 1000, 1200);

        Assertions.assertEquals(true, t1.compareTo(t2) < 0);
        Assertions.assertEquals(true, t2.compareTo(t1) > 0);
        Assertions.assertEquals(true, t1.compareTo(t3) == 0);
    }

    // test search - price
    @Test
    public void shouldFindTicket() {
        Ticket t1 = new Ticket("LON", "BER", 10, 1000, 1200);
        Ticket t2 = new Ticket("LON", "BER", 20, 1000, 1100);

        AviaSouls as = new AviaSouls();
        as.add(t2);
        as.add(t1);

        Ticket[] result = as.search("LON", "BER");

        Assertions.assertEquals(t1, result[0]);
        Assertions.assertEquals(t2, result[1]);
    }

    // TicketTimeComparator - flight time
    @Test
    public void shouldCompareTicketsByFlightTime() {
        Ticket t1 = new Ticket("LON", "BER", 10, 1000, 1200);
        Ticket t2 = new Ticket("LON", "BER", 20, 1000, 1100);
        Ticket t3 = new Ticket("LON", "BER", 30, 1200, 1400);

        TicketTimeComparator ttc = new TicketTimeComparator();

        Assertions.assertEquals(true, ttc.compare(t1, t2) > 0);
        Assertions.assertEquals(true, ttc.compare(t2, t1) < 0);
        Assertions.assertEquals(true, ttc.compare(t1, t3) == 0);
    }

    // method search searchAndSortBy(from, to, new TicketTimeComparator() ) - flight time
    @Test
    public void shouldFindAndSortTicketsByFlightTime() {
        Ticket t1 = new Ticket("LON", "BER", 10, 1000, 1200);
        Ticket t2 = new Ticket("LON", "BER", 20, 1000, 1100);

        AviaSouls as = new AviaSouls();
        as.add(t1);
        as.add(t2);

        Ticket[] result = as.searchAndSortBy("LON", "BER", new TicketTimeComparator());

        Assertions.assertEquals(t2, result[0]);
        Assertions.assertEquals(t1, result[1]);
    }
}