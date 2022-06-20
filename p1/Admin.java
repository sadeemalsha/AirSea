package p1;



import java.util.List;
import java.util.Scanner;


public class  Admin extends User {
    Scanner input = new Scanner(System.in);
    public Admin(String username,String password){
        super(username, password);
    }

    public void addFlight(List<Flight> flightsArray){
        System.out.println("Please Enter the Following Information");
        System.out.println("Flight NO : ");
        String flightNO = input.next().toUpperCase();
        if(flightExists(flightsArray, flightNO)) return;
        System.out.println("Destination City : ");
        String destCity = input.next().toUpperCase();
        System.out.println("Arrival City : ");
        String arrivalCity = input.next().toUpperCase();
        System.out.println("Day of Flight : ");
        String dayOfFlight = input.next().toUpperCase();
        Flight flight3 = new Flight(flightNO, destCity, arrivalCity, dayOfFlight);
        flightsArray.add(flight3);
        System.out.println("Your Information is Saved Successfully ");
    }
    public void modifyFlight(List<Flight> flightsArray){
        System.out.println("Please Enter the Following Information");
        System.out.println("Flight Number: ");
        String flightNO = input.next().toUpperCase();
        Boolean found = false;
        for(Flight f : flightsArray) {
            if(f.flightNO.equalsIgnoreCase(flightNO)) {
                System.out.println("Flight Number: "+flightNO+" found.");
                found = true;
                System.out.println(f);
                String choose = "";
                String newInput = "";
                Boolean changed = false;
                do {
                    System.out.println("What do you want to change:\n"+
                            "(1) - Flight Number.\n"+
                            "(2) - Destination city.\n"+
                            "(3) - Arrival city.\n"+
                            "(4) - Day of Flight.\n"+
                            "type ESC to exit");
                    choose = input.next();
                    switch(choose) {
                        case "1":
                            System.out.println("Please type new flight Number: ");
                            newInput = input.next().toUpperCase();
                            if(flightExists(flightsArray, newInput)) {
                                return;
                            }
                            f.flightNO=newInput;
                            System.out.println("New flight Number: "+newInput+" saved");
                            changed=true;
                            break;
                        case "2":
                            System.out.println("Please type new destination city: ");
                            newInput = input.next().toUpperCase();
                            f.setDestCity(newInput);
                            System.out.println("New destination city: "+newInput+" saved");
                            changed=true;
                            break;
                        case "3":
                            System.out.println("Please type new arrival city: ");
                            newInput = input.next().toUpperCase();
                            f.setArrivalCity(newInput);
                            System.out.println("New arrival city: "+newInput+" saved");
                            changed=true;
                            break;
                        case "4":
                            System.out.println("Please type new day of flight: ");
                            newInput = input.next().toUpperCase();
                            f.setDayOfFlight(newInput);
                            System.out.println("New day of flight: "+newInput+" saved");
                            changed=true;
                            break;
                    }

                }while(!choose.equals("ESC"));
                if(changed) {
                    System.out.println("Your Information is Saved Successfully");
                    System.out.println("New information of flight: "+f);
                }
            }
        }
        if(!found) {
            System.out.println("Flight Number: "+flightNO+" not found.");
        }
    }

    public void deleteFlight(List<Flight> flightsArray) {
        String flightNo;
        do {
            System.out.println("Please type the Number of flight you want to delete(ESC to exit):");
            flightNo = input.next().toUpperCase();
            if(!flightNo.equals("ESC")) {
                deleteFlight(flightsArray, flightNo);
            }
        }while(!flightNo.equals("ESC"));
    }
    public void deleteFlight(List<Flight> flightsArray, String flightNo) {
        Flight toRemove = null;
        for(Flight f : flightsArray) {
            if(f.flightNO.equalsIgnoreCase(flightNo)) {
                toRemove = f;
            }
        }
        deleteFlight(flightsArray, toRemove);
    }
    public void deleteFlight(List<Flight> flightsArray, Flight toRemove) {
        if(toRemove!=null) {
            flightsArray.remove(toRemove);
            System.out.println("The flight Number "+toRemove.flightNO+" deleted.");
        }
    }
    private boolean flightExists(List<Flight> flightsArray, String flightNO) {
        for(Flight f : flightsArray) {
            if(f.flightNO.equalsIgnoreCase(flightNO)) {
                System.out.println("Flight with this Number already exists.");
                return true;
            }
        }
        return false;
    }
}


