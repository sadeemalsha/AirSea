package p1;

import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Flight> flightsArray = new ArrayList<>();
        List<Passenger> personArray = new ArrayList<>();
        Flight flight1 = new Flight("D101R", "DMM", "RUH", "SUNDAY");
        Flight flight2 = new Flight("R102D", "RUH", "DMM", "MONDAY");
        Flight flight3 = new Flight("D103J", "DMM", "JED", "TUESDAY");
        Flight flight4 = new Flight("J104D", "JED", "DMM", "WEDNESDAY");

        Flight flight5 = new Flight("R105J", "RUH", "JED", "THURSDAY");
        Flight flight6 = new Flight("J106R", "JED", "RUH", "FRIDAY");



        Flight flight = new Flight();
        flightsArray.add(flight1);
        flightsArray.add(flight2);
        flightsArray.add(flight3);
        flightsArray.add(flight4);
        flightsArray.add(flight5);
        flightsArray.add(flight6);



        Passenger person = new Passenger();

        Scanner input = new Scanner(System.in);
        int choice;
        int passChoice;
        int adminChoice;
        Admin admin;

        String username;
        String password;
        System.out.println("\n\n\n\n\n\n\n");
        System.out.println("\t\t\t\t\t\t ✈ ✈ ✈ ✈ ✈ ✈ WELCOME ✈ ✈ ✈ ✈ ✈ ✈ ");
        System.out.println("\t\t\t\t\t\t     To AirSea Reservation System  ");
        System.out.println();
        do {

            System.out.println("\t\t\t\t\t\t ◉ Please Enter a Number :  ");
            System.out.println("\t\t\t\t\t\t  (1) - \uD83D\uDD12 Admin  ");
            System.out.println("\t\t\t\t\t\t  (2) - \uD83D\uDC64 Passenger  ");
            System.out.println("\t\t\t\t\t\t  (3) -  Exit  ");

            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t  ");
            choice = input.nextInt();
            if (choice == 1) {
                do {
                    System.out.println("\nEnter your username and password to login to your account.");

                    System.out.println("Username: ");
                    username = input.next();

                    System.out.println("Password: ");
                    password = input.next();

                    admin = new Admin(username, password);

                    if (admin.login())
                        System.out.println("You are logged in!");
                    else
                        System.out.println("The username and password you entered are incorrect.");

                } while (admin.login() == false);
                {

                    do {
                        System.out.println(" How Can We Help You ?  ");

                        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t   ◉ Please Enter a Number :  ");
                        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t   (1) - Add Flight  ");

                        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t   (2) - Modify Flight  ");

                        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t   (3) - Delete Flight  ");
                        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t   (4) - Print Flights  ");

                        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t   (5) - List Of Passengers  ");
                        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t   (6) - Seats Available  ");
                        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t   (7) - EXIT  ");


                        adminChoice = input.nextInt();

                        switch (adminChoice) {
                            case 1:
                                admin.addFlight(flightsArray);
                                break;
                            case 2:
                                admin.modifyFlight(flightsArray);
                                break;
                            case 3:
                                admin.deleteFlight(flightsArray);
                                break;
                            case 4:
                                for (int i=0;i<flightsArray.size();i++){
                                    System.out.println(flightsArray.get(i).toString());}
                                break;
                            case 5:
                                if (Passenger.numOfpassengers > 0) {


                                    System.out.println("There Are " +Passenger.numOfpassengers+ " Passengers \n  There Details Are : \n\n");
                                    for (int i=0;i<personArray.size();i++){
                                        System.out.println(personArray.get(i).toString()+"\n*************************");}}
                                else
                                    System.out.println("There is No Bookings Yet ! \n");

                                break;
                            case 6:
                                System.out.printf("There is  %d for  First-Class Available  \n",FirstClass.noOfSeatsFirstClass);
                                System.out.printf("There is  %d for  Economy-Class Available \n",Economy.noOfSeatsEco);
                                break;

                            case 7:
                                System.out.println("Have a great day");
                                break;
                            default:
                                System.out.println("WRONG ENTRY!!");
                                System.out.println("Please Enter Within the Choices Given ");

                        }

                    } while ((adminChoice != 7));
                }

            } else if (choice == 2) {

                System.out.println("\t\t\t\t\t\t✈ ✈ ✈ ✈ ✈ ✈ WELCOME ✈ ✈ ✈ ✈ ✈ ✈ ");
                System.out.println("\t\t\t\t\t\t    To AirSea Reservation System  ");
                System.out.println();

                System.out.println(" How Can We Help You ?  ");

                do {
                    System.out.println("\t\t\t\t\t\t   ◉ Please Enter a Number :  ");
                    System.out.println("\t\t\t\t\t\t   (1) - Book a Ticket  ");

                    System.out.println("\t\t\t\t\t\t   (2) - Search for Flight  ");

                    System.out.println("\t\t\t\t\t\t   (3) - Cancel Booking  ");
                    System.out.println("\t\t\t\t\t\t   (4) - EXIT  ");
                    passChoice = input.nextInt();

                    switch (passChoice) {
                        case 1:
                            person.creatPassenger(personArray, flightsArray);

                            System.out.println("Thank you for Your Information\n");
                            System.out.println("***********************************");

                            System.out.println("\nYour Ticket Details : ");



                            System.out.println(person.toString());
                            break;
                        case 2:
                            flight.searchFlights(flightsArray);
                            break;
                        case 3:
                            System.out.println("Enter your First and Last Name to Cancel your Booking");
                            person.cancel(personArray);

                            break;
                        case 4:
                            System.out.println("Have a great day");
                            break;
                        default:
                            System.out.println("WRONG ENTRY!!");
                            System.out.println("Please Enter Within the Choices Given ");

                    }

                } while ((passChoice != 4));
            }

        } while (choice != 3);

    }
}
