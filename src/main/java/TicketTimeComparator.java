import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int t1FlightTime = t1.getTimeTo() - t1.getTimeFrom();
        int t2FlightTime = t2.getTimeTo() - t2.getTimeFrom();

        return Integer.compare(t1FlightTime, t2FlightTime);
    }
}