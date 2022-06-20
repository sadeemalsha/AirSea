package p1;


import java.util.List;
import java.util.Scanner;

public class Flight {

    public String flightNO;
    private String destCity;
    private String arrivalCity;
    private String dayOfFlight;
    Scanner input = new Scanner(System.in);

    public Flight() {
    }

    public Flight(String flightNO, String destCity, String arrivalCity, String dayOfFlight) {
        this.flightNO = flightNO;
        this.destCity = destCity;
        this.arrivalCity = arrivalCity;
        this.dayOfFlight = dayOfFlight;
    }

    public String getDestCity() {
        return destCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public String getDayOfFlight() {
        return dayOfFlight;
    }
    public String getFlightNO() {
        return flightNO;
    }

    public void setDestCity(String destCity) {
        this.destCity = destCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public void setDayOfFlight(String dayOfFlight) {
        this.dayOfFlight = dayOfFlight;
    }

    public void searchFlights(List<Flight> flight) {
        boolean found = false;
        String searchDest, searchArr;
        System.out.print("Destaintion City ? ");
        searchDest = input.next();
        System.out.println();
        System.out.print("Arrival City ? ");
        searchArr = input.next();

        if (flight.size() > 0) {
            for (Flight f : flight) {
                if ((f.destCity.equalsIgnoreCase(searchDest)) && (f.arrivalCity.equalsIgnoreCase(searchArr))) {
                    found = true;
                    System.out.println(f.toString());
                }
            }
        }
        if (found == false) {
            System.out.println("There is no flight with this information");
        }
    }

    public Flight selectFlights(List<Flight> flight) {
        Flight found = null;
        do {
            String searchDest, searchArr;
            System.out.print("Destaintion City ? ");
            searchDest = input.next();
            System.out.println();
            System.out.print("Arrival City ? ");
            searchArr = input.next();

            if (flight.size() > 0) {
                for (Flight f : flight) {

                    if ((f.destCity.equalsIgnoreCase(searchDest)) && (f.arrivalCity.equalsIgnoreCase(searchArr))) {
                        found = f;
                        return f;
                    }
                }
                if (found == null)
                    System.out.println("No Flight Available please Try Again");
            }
        } while (found == null);
        return null;
    }

    @Override
    public String toString() {
        return "Flight No: "+flightNO+"\t\t\t\t \uD83D\uDEEB Destination City: "+destCity+"\t\t\t\t \uD83D\uDEECArrival City: "+arrivalCity+
                "\t\t\t\t \uD83D\uDDD3 Flight Day:  "+dayOfFlight;
    }
}
