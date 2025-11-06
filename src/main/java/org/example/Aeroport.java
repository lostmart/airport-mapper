package org.example;

public class Aeroport {
    // Instance variables (properties) - private so they're encapsulated
    private final String IATA;
    private final String Name;
    private String country;
    private final double latitude;
    private final double longitude;

    // Constructor - called when creating new Aeroport("CDG", ...)
    public Aeroport(String IATA, String Name, double latitude, double longitude) {
        this.IATA = IATA;
        this.Name = Name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getter methods - allow reading private properties
    public String getIATA() {
        return IATA;
    }

    public String getName() {
        return Name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    // Calculate distance to another airport
    public double calculDistance(Aeroport other) {
        // Difference in latitudes (θ)
        double thetaDiff = other.latitude - this.latitude;

        // Difference in longitudes (φ)
        double phiDiff = other.longitude - this.longitude;

        // Average latitude for cosine calculation
        double avgTheta = (other.latitude + this.latitude) / 2.0;

        // Apply the formula: (θ₂-θ₁)² + [(φ₂-φ₁)×cos((θ₂+θ₁)/2)]²
        double distance = Math.pow(thetaDiff, 2) +
                Math.pow(phiDiff * Math.cos(Math.toRadians(avgTheta)), 2);

        return distance;
    }

    // String representation for printing/debugging
    @Override
    public String toString() {
        return Name + " (" + IATA + ") - Lat: " + latitude + ", Lon: " + longitude;
    }
}
