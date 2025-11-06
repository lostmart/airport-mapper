package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class World {
    private final ArrayList<Aeroport> list = new ArrayList<>();

    public World(String fileName) {
        try {
            BufferedReader buf = new BufferedReader(new FileReader(fileName));
            String s = buf.readLine(); // Skip header
            s = buf.readLine(); // Read first data line

            while (s != null) {
                // DON'T remove quotes yet - we need them to identify the coordinates field
                String[] fields = s.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                // Now remove quotes from all fields
                for (int i = 0; i < fields.length; i++) {
                    fields[i] = fields[i].replaceAll("\"", "").trim();
                }

                if (fields.length > 11 && fields[1].equals("large_airport")) {
                    try {
                        String iata = fields[9].trim();
                        String name = fields[2].trim();
                        String coordinates = fields[11].trim();

                        if (!iata.isEmpty() && !coordinates.isEmpty()) {
                            // Now split coordinates which are "longitude, latitude"
                            String[] coords = coordinates.split("[, ]+");

                            if (coords.length >= 2) {
                                double longitude = Double.parseDouble(coords[0]);
                                double latitude = Double.parseDouble(coords[1]);

                                Aeroport airport = new Aeroport(iata, name, latitude, longitude);
                                list.add(airport);
                            }
                        }
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        // Skip invalid entries
                    }
                }
                s = buf.readLine();
            }
            buf.close();
            System.out.println("Loaded " + list.size() + " large airports.");
        } catch (Exception e) {
            System.out.println("Maybe the file isn't there?");
            if (!list.isEmpty()) {
                System.out.println("Last airport loaded: " + list.get(list.size() - 1));
            }
            e.printStackTrace();
        }
    }

    public ArrayList<Aeroport> getList() {
        return list;
    }

    public Aeroport findByCode(String code) {
        for (Aeroport airport : list) {
            if (airport.getIATA().equals(code)) {
                return airport;
            }
        }
        return null;
    }

    public Aeroport findNearestAirport(double longitude, double latitude) {
        if (list.isEmpty()) {
            return null;
        }

        Aeroport location = new Aeroport("", "Search Location", latitude, longitude);

        Aeroport nearest = list.get(0);
        double minDistance = location.calculDistance(nearest);

        for (Aeroport airport : list) {
            double distance = location.calculDistance(airport);
            if (distance < minDistance) {
                minDistance = distance;
                nearest = airport;
            }
        }

        return nearest;
    }

    public double distance(double lon1, double lat1, double lon2, double lat2) {
        Aeroport a1 = new Aeroport("", "", lat1, lon1);
        Aeroport a2 = new Aeroport("", "", lat2, lon2);
        return a1.calculDistance(a2);
    }
}