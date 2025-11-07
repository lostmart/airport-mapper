package test;

import org.example.Aeroport;
import org.example.World;

public class WorldTest {




    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   Testing World Class                 ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        // Test 1: Load airports from CSV
        System.out.println("📂 Test 1: Loading airports from CSV...");
        World w = new World("./data/airport-codes_no_comma.csv");

        // Display number of airports loaded
        System.out.println("✅ Loaded " + w.getList().size() + " airports\n");

        // Test 2: Display first 5 airports
        System.out.println("📍 Test 2: Displaying first 10 airports:");
        w.getList().stream()
                .limit(10)
                .forEach(System.out::println);
        System.out.println();
        // w.getList().forEach(airport -> System.out.println(airport));   // all 600 airports ...
        // w.getList().forEach(airport -> System.out.println(airport.getIATA()));  // all 600 airports codes ...

        // Test 3: Find a specific airport (example: CDG, ORY, YYC)
        System.out.println("🔍 Test 3: Finding airport by IATA code (CDG):");
        // found airport set as an "Aeroport" variable and then getting its index position
        Aeroport found = w.getList().stream()
                .filter(airport -> airport.getIATA().equals("CDG"))
                .findFirst()
                .orElse(null);

        if (found != null) {
            int index = w.getList().indexOf(found);
            System.out.println("Found at index: " + index + ": " + found);
            System.out.println("Whole class name: " +  found.getClass().getName());
            System.out.println("Simple class name: " + found.getClass().getSimpleName());
        } else {
            System.out.println("Airport not found");
        }



        w.getList().stream()
                .filter(airport -> airport.getIATA().equals("ORY"))
                .forEach(airport -> System.out.println("Found: " + airport));
        w.getList().stream()
                .filter(airport -> airport.getIATA().equals("YYC"))
                .forEach(airport -> System.out.println("Found: " + airport));
        System.out.println();

        // Test 4: Calculate distance between two airports
        if (w.getList().size() >= 2) {
            System.out.println("📏 Test 4: Calculating distance between first two airports:");
            Aeroport airport1 = w.getList().get(327);
            Aeroport airport2 = w.getList().get(1);
            System.out.println("   " + airport1.getName() + " → " + airport2.getName());
            double distance = airport1.calculDistance(airport2);
            System.out.println(airport1.getName() + " → " + airport2.getName());
            System.out.println("Distance: " + String.format("%.4f", distance) + " units\n");
        }

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   All Tests Completed! ✅              ║");
        System.out.println("╚════════════════════════════════════════╝");







        // System.out.println("✅ CSV loaded successfully\n" + w.getList() + " airports loaded");

        // Test 2: Find airport by code
//        System.out.println("🔍 Test 2: Finding airports by IATA code...");
//        Aeroport cdg = w.findByCode("CDG");
//        Aeroport ory = w.findByCode("ORY");
//        Aeroport jfk = w.findByCode("JFK");
//        System.out.println("   CDG: " + cdg);
//        System.out.println("   ORY: " + ory);
//        System.out.println("   JFK: " + jfk);
//        System.out.println("✅ findByCode works correctly\n");

        // Test 3: Find nearest airport to Paris coordinates
//        System.out.println("📍 Test 3: Finding nearest airport to Paris (2.316, 48.866)...");
//        Aeroport nearest = w.findNearestAirport(2.316, 48.866);
//        double distance = w.distance(2.316, 48.866,
//                nearest.getLongitude(), nearest.getLatitude());
//        System.out.println("   Nearest: " + nearest);
//        System.out.println("   Distance: " + distance);
//        System.out.println("   (Should be ORY - Orly)");
//        System.out.println("✅ findNearestAirport works correctly\n");

        // Test 4: Compare distances
//        System.out.println("📏 Test 4: Comparing distances from Paris...");
//        double distanceCDG = w.distance(2.316, 48.866,
//                cdg.getLongitude(), cdg.getLatitude());
//        double distanceORY = w.distance(2.316, 48.866,
//                ory.getLongitude(), ory.getLatitude());
//        System.out.println("   Distance to CDG: " + distanceCDG);
//        System.out.println("   Distance to ORY: " + distanceORY);
//        System.out.println("   ORY is closer: " + (distanceORY < distanceCDG));
//        System.out.println("✅ Distance calculations correct\n");

        // Test 5: Test with invalid code
//        System.out.println("❓ Test 5: Testing with invalid code...");
//        Aeroport invalid = w.findByCode("INVALID");
//        System.out.println("   Result for 'INVALID': " + invalid);
//        System.out.println("✅ Returns null for invalid codes\n");

        // Test 6: Random coordinates
//        System.out.println("🌍 Test 6: Finding nearest to random location (0, 0)...");
//        Aeroport equator = w.findNearestAirport(0, 0);
//        System.out.println("   Nearest to (0,0): " + equator);
//        System.out.println("✅ Works for any coordinates\n");

//        System.out.println("╔════════════════════════════════════════╗");
//        System.out.println("║   All Tests Completed! ✅              ║");
//        System.out.println("╚════════════════════════════════════════╝");
    }
}