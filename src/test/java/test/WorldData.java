package test;
import java.io.BufferedReader;
import java.io.FileReader;


public class  WorldData {
    public static void main(String[] args) {
        try {
            BufferedReader buf = new BufferedReader(new FileReader("./data/airport-codes_no_comma.csv"));
            String s = buf.readLine();

            System.out.println("Header: " + s);
            System.out.println("Header fields: " + s.split(",").length);

            // Read a few lines
            for (int i = 0; i < 5; i++) {
                s = buf.readLine();
                if (s != null) {
                    s = s.replaceAll("\"", "");
                    String[] fields = s.split(",");
                    System.out.println("\nLine " + (i+1) + ": " + fields.length + " fields");
                    System.out.println("Type (field[1]): '" + fields[1] + "'");
                    if (fields.length > 11) {
                        System.out.println("IATA (field[10]): '" + fields[9] + "'");
                        System.out.println("Coords (field[11]): '" + fields[11] + "'");
                    }
                    System.out.println("Is large_airport? " + fields[1].equals("large_airport"));
                }
            }

            buf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}