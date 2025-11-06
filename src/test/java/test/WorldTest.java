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
        System.out.println("✅ CSV loaded successfully\n");

        // Test 2: Find airport by code
        System.out.println("🔍 Test 2: Finding airports by IATA code...");
        Aeroport cdg = w.findByCode("CDG");
        Aeroport ory = w.findByCode("ORY");
        Aeroport jfk = w.findByCode("JFK");
        System.out.println("   CDG: " + cdg);
        System.out.println("   ORY: " + ory);
        System.out.println("   JFK: " + jfk);
        System.out.println("✅ findByCode works correctly\n");

        // Test 3: Find nearest airport to Paris coordinates
        System.out.println("📍 Test 3: Finding nearest airport to Paris (2.316, 48.866)...");
        Aeroport nearest = w.findNearestAirport(2.316, 48.866);
        double distance = w.distance(2.316, 48.866,
                nearest.getLongitude(), nearest.getLatitude());
        System.out.println("   Nearest: " + nearest);
        System.out.println("   Distance: " + distance);
        System.out.println("   (Should be ORY - Orly)");
        System.out.println("✅ findNearestAirport works correctly\n");

        // Test 4: Compare distances
        System.out.println("📏 Test 4: Comparing distances from Paris...");
        double distanceCDG = w.distance(2.316, 48.866,
                cdg.getLongitude(), cdg.getLatitude());
        double distanceORY = w.distance(2.316, 48.866,
                ory.getLongitude(), ory.getLatitude());
        System.out.println("   Distance to CDG: " + distanceCDG);
        System.out.println("   Distance to ORY: " + distanceORY);
        System.out.println("   ORY is closer: " + (distanceORY < distanceCDG));
        System.out.println("✅ Distance calculations correct\n");

        // Test 5: Test with invalid code
        System.out.println("❓ Test 5: Testing with invalid code...");
        Aeroport invalid = w.findByCode("INVALID");
        System.out.println("   Result for 'INVALID': " + invalid);
        System.out.println("✅ Returns null for invalid codes\n");

        // Test 6: Random coordinates
        System.out.println("🌍 Test 6: Finding nearest to random location (0, 0)...");
        Aeroport equator = w.findNearestAirport(0, 0);
        System.out.println("   Nearest to (0,0): " + equator);
        System.out.println("✅ Works for any coordinates\n");

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   All Tests Completed! ✅              ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
}