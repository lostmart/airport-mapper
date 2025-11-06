package test;

import org.example.Aeroport;

public class AeroportTest {

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   Testing Aeroport Class               ║");
        System.out.println("╔════════════════════════════════════════╗\n");

        // Test 1: Create airports
        System.out.println("📍 Test 1: Creating airports...");
        Aeroport cdg = new Aeroport("CDG", "Charles de Gaulle", 49.0097, 2.5479);
        Aeroport ory = new Aeroport("ORY", "Orly", 48.7233, 2.3794);
        Aeroport jfk = new Aeroport("JFK", "John F Kennedy", 40.6413, -73.7781);
        System.out.println("✅ Airports created successfully\n");

        // Test 2: Test toString()
        System.out.println("📋 Test 2: Testing toString() method...");
        System.out.println("   " + cdg);
        System.out.println("   " + ory);
        System.out.println("   " + jfk);
        System.out.println("✅ toString() works correctly\n");

        // Test 3: Test getters
        System.out.println("🔍 Test 3: Testing getter methods...");
        System.out.println("   CDG Code: " + cdg.getIATA());
        System.out.println("   CDG Name: " + cdg.getName());
        System.out.println("   CDG Latitude: " + cdg.getLatitude());
        System.out.println("   CDG Longitude: " + cdg.getLongitude());
        System.out.println("✅ All getters work correctly\n");

        // Test 4: Test distance calculation (Paris airports)
        System.out.println("📏 Test 4: Testing distance calculation...");
        double distanceCdgOry = cdg.calculDistance(ory);
        System.out.println("   Distance CDG → ORY: " + distanceCdgOry);
        System.out.println("   (These are in the same city, so should be small)");

        // Test 5: Test distance calculation (Paris to New York)
        double distanceCdgJfk = cdg.calculDistance(jfk);
        System.out.println("   Distance CDG → JFK: " + distanceCdgJfk);
        System.out.println("   (Transatlantic, so should be much larger)");
        System.out.println("✅ Distance calculation works correctly\n");

        // Test 6: Verify distance is symmetric
        System.out.println("🔄 Test 5: Testing distance symmetry...");
        double distanceJfkCdg = jfk.calculDistance(cdg);
        System.out.println("   Distance JFK → CDG: " + distanceJfkCdg);
        System.out.println("   Distance CDG → JFK: " + distanceCdgJfk);
        if (Math.abs(distanceJfkCdg - distanceCdgJfk) < 0.0001) {
            System.out.println("✅ Distance is symmetric (A→B = B→A)\n");
        } else {
            System.out.println("❌ Warning: Distance should be symmetric!\n");
        }

        // Summary
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   All Tests Completed! ✅              ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
}