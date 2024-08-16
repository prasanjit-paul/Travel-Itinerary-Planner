import java.util.Scanner;

public class TravelItineraryPlanner {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the Travel Itinerary Planner!");
            System.out.print("Enter the number of destinations: ");
            int numDestinations = scanner.nextInt();

            String[] destinations = new String[numDestinations];
            for (int i = 0; i < numDestinations; i++) {
                System.out.print("Enter destination " + (i + 1) + ": ");
                destinations[i] = scanner.next();
            }

            System.out.print("Enter the start date of your travel (MM/DD/YYYY): ");
            String startDate = scanner.next();

            System.out.println("Your Travel Itinerary:");
            System.out.println("Destinations:");
            for (String destination : destinations) {
                System.out.println("- " + destination);
            }
            System.out.println("Start Date: " + startDate);
        }
    }
}
