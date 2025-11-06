# Airport Mapper

This repository contains a Java application that takes an airport code and returns the corresponding airport name.

The application uses a simple HashMap to store the airport codes and their corresponding names. The application provides a simple command line interface to query the map.

The application is built using Maven and can be run from the command line using the following command:

mvn exec:java -Dexec.mainClass="org.example.AirportMapper"

The application takes an optional command line argument, the airport code to look up. If no argument is provided, the application will print out all the airport codes and their corresponding names.

For example, to look up the name of the airport with code "LHR", the following command can be used:

mvn exec:java -Dexec.mainClass="org.example.AirportMapper" -Dexec.args="LHR"

The application will print out the name of the airport with code "LHR".

To run the application, you will need to have Maven installed on your system. You can download Maven from the following URL:

https://maven.apache.org/download.cgi

To build the application, you can use the following command:

mvn clean install

To run the application, you can use the following command:

mvn exec:java -Dexec.mainClass="org.example.AirportMapper"
    