import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Itinerary {
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Destination> destinations;

    public Itinerary(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.destinations = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public void displayItinerary() {
        System.out.println("Itinerary from " + startDate + " to " + endDate);
        for (Destination dest : destinations) {
            System.out.println("- " + dest);
        }
    }

    public String getItineraryDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("Itinerary from ").append(startDate).append(" to ").append(endDate).append("\n");
        for (Destination dest : destinations) {
            sb.append("- ").append(dest).append("\n");
        }
        return sb.toString();
    }
}
